package top.by.xiceos.cache.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import top.by.xiceos.cache.AbstractXiceOSCache;
import top.by.xiceos.config.XiceOSCacheConfig;
import top.by.xiceos.constant.XiceOSConstant;
import top.by.xiceos.util.PropertiesUtil;
import top.by.xiceos.util.SerializeUtil;
import top.by.xiceos.util.XiceOSUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * <p>Title: RedisClientSingle</p>
 * <p>Description: redis缓存操作实现类</p>
 *
 * <p>
 *     单机模式redis的操作实现 <br />
 * </p>
 *
 * @author zwp
 * @date 2018/10/10 17:16
 */
public class RedisClientSingle extends AbstractXiceOSCache {
    /**
     * 默认缓存名称
     */
    public static final String DEFAULT_CACHE_NAME = (String) ((Properties) new XiceOSCacheConfig().getModuleConfig((String) XiceOSConstant._NULL)).get("xiceos.cache.default.name");

    private final String redis_config_path = "/redis/redis.properties";

    private JedisPool jedisPool;

    private ThreadLocal<Jedis> threadLocal = new ThreadLocal<Jedis>();

    private static RedisClientSingle single;

    /**
     * 初始化
     */
    private RedisClientSingle() {
        this.initPool();
    }

    /**
     * 初始化连接池
     */
    private void initPool() {
        try {
            // 加载配置文件
            Properties properties = PropertiesUtil.getInstance().loadProperties(this.redis_config_path);

            // 创建连接池实例配置
            JedisPoolConfig config = new JedisPoolConfig();

            // 设置连接池配置项
            config.setMaxTotal(Integer.valueOf(properties.getProperty("redis.pool.maxActive")));
            config.setMaxIdle(Integer.valueOf(properties.getProperty("redis.pool.maxIdle")));
            config.setMaxWaitMillis(Long.valueOf(properties.getProperty("redis.pool.maxWait")));
            config.setTestOnBorrow(Boolean.valueOf(properties.getProperty("redis.pool.testOnBorrow")));
            config.setTestOnReturn(Boolean.valueOf(properties.getProperty("redis.pool.testOnReturn")));

            // 是否启用密码连接
            boolean authEnabled = Boolean.valueOf((String) properties.get("xiceos.cache.auth.enabled"));

            if (authEnabled) {
                // 实例化连接池
                jedisPool = new JedisPool(config,
                        properties.getProperty("redis.single.host"),
                        Integer.valueOf(properties.getProperty("redis.single.port")),
                        Integer.valueOf(properties.getProperty("redis.single.timeout")),
                        properties.getProperty("redis.single.auth"));

            } else {
                // 实例化连接池
                jedisPool = new JedisPool(config,
                        properties.getProperty("redis.single.host"),
                        Integer.valueOf(properties.getProperty("redis.single.port")),
                        Integer.valueOf(properties.getProperty("redis.single.timeout")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个单例类
     *
     * @return
     */
    public synchronized static RedisClientSingle getInstance() {
        if (single == null) {
            synchronized (PropertiesUtil.class) {
                if (single == null) {
                    single = new RedisClientSingle();
                }
            }
        }
        return single;
    }

    /**
     * 获取一个redis连接
     *
     * @return
     */
    public synchronized Jedis getConnection() {
        Jedis jedis = threadLocal.get();

        if (XiceOSUtil.isNull(jedis)) {
            if (XiceOSUtil.isNull(this.jedisPool)) {
                this.initPool();
            }

            jedis = this.jedisPool.getResource();

            threadLocal.set(jedis);
        }

        return jedis;
    }

    /**
     * 关闭redis连接
     */
    public void closeConnection() {
        Jedis jedis = threadLocal.get();
        if (XiceOSUtil.isNotNull(jedis)) {
            jedis.close();
        }

        threadLocal.set((Jedis) XiceOSConstant._NULL);
    }

    /**
     * 关闭redis池连接
     */
    public void closePool() {
        if (XiceOSUtil.isNotNull(this.jedisPool)) {
            this.jedisPool.close();
        }
    }

    @Override
    public void set(String cacheName, Object key, Object val) {
        if (XiceOSUtil.isNull(cacheName)) {
            cacheName = DEFAULT_CACHE_NAME;
        }

        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        String cacheVal = SerializeUtil.serialize(val);

        try {
            jedis.hset(cacheName, cacheKey, cacheVal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * 设置缓存中的键值的超时时间、可以用来作为分布式锁 </br>
     *
     * 功能描述：
     *          主要还是锁的机制，利用过期时间判断是否存在，推荐的做法是设置当前的时间戳为键的值；
     *       如果设置的‘键’存在于缓存中，则返回false，说明现在被一个进程使用中；如果设置的‘键’不
     *       存在于缓存中，则返回true，表示该进程获得锁。
     *          过期时间，在获得锁的过程中在尽可能控制的时间范围内完成对应的业务处理，则会自动释
     *       放锁，若不能控制在设置的时间内完成所处理的业务不推荐使用此方法。
     *
     * @param key       键
     * @param val       值
     * @param timeout   超时时间、当值为-1时不设置超时时间、单位为秒
     *
     * @return 返回true表示设置键值成功
     */
    public boolean set(Object key, Object val, int timeout) {
        boolean isExist = true;

        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        String cacheVal = SerializeUtil.serialize(val);

        try {
            if (jedis.exists(cacheKey)) {
                isExist = false;
            } else {
                jedis.set(cacheKey, cacheVal);
                if (timeout != -1) {
                    jedis.expire(cacheKey, timeout);
                }
                isExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return isExist;
    }

    /**
     * 分布式锁的实现
     *
     * 功能描述：
     *          主要还是锁的机制，利用过期时间判断是否存在，推荐的做法是设置当前的时间戳为键的值；
     *       如果设置的‘键’存在于缓存中，则返回false，说明现在被一个进程使用中；如果设置的‘键’不
     *       存在于缓存中，则返回true，表示该进程获得锁。
     *
     * @param key 键
     * @param val 值
     *
     * @return 返回true表示锁获取成功
     */
    public boolean lock(Object key, Object val) {
        return this.set(key, val, -1);
    }

    /**
     * 释放锁
     *
     * @param key
     * @return
     */
    public boolean unLock(Object key) {
        return this.remove(key);
    }

    @Override
    public <T> T get(String cacheName, Object key) {
        if (XiceOSUtil.isNull(cacheName)) {
            cacheName = DEFAULT_CACHE_NAME;
        }

        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        try {
            String cacheVal = jedis.hget(cacheName, cacheKey);

            if (XiceOSUtil.isNotNull(cacheKey)) {
                return (T) SerializeUtil.deserialize(cacheVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return (T) XiceOSConstant._NULL;
    }

    /**
     * 根据键获取值
     *
     * @param key 键
     * @param <T> 值
     * @return
     */
    public <T> T get(Object key) {
        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        try {
            String cacheVal = jedis.get(cacheKey);

            if (XiceOSUtil.isNotNull(cacheKey)) {
                return (T) SerializeUtil.deserialize(cacheVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return (T) XiceOSConstant._NULL;
    }

    @Override
    public List<String> getAllKeys(String cacheName) {
        Jedis jedis = this.getConnection();
        List<String> keys = new ArrayList<String>();

        try {
            Set<String> cacheKeys = jedis.hkeys(cacheName);

            for (String cacheKey: cacheKeys
                 ) {
                keys.add((String) SerializeUtil.deserialize(cacheKey));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return keys;
    }

    @Override
    public void update(String cacheName, Object key, Object val) {
        if (XiceOSUtil.isNull(cacheName)) {
            cacheName = DEFAULT_CACHE_NAME;
        }

        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        try {
            if (jedis.hexists(cacheName, cacheKey)) {
                jedis.hdel(cacheName, cacheKey);
            }

            set(cacheName, key, val);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void remove(String cacheName, Object key) {
        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        try {
            if (jedis.hexists(cacheName, cacheKey)) {
                jedis.hdel(cacheName, cacheKey);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * 根据键删除缓存的数据
     *
     * @param key 键
     * @return
     */
    public boolean remove(Object key) {
        boolean isExist = true;

        Jedis jedis = this.getConnection();

        String cacheKey = SerializeUtil.serialize(key);

        try {
            if (jedis.exists(cacheKey)) {
                jedis.del(cacheKey);
                isExist = true;
            } else {
                isExist = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            isExist = false;
        } finally {
            this.closeConnection();
        }

        return isExist;
    }

    @Override
    public void removeAll(String cacheName) {
        Jedis jedis = this.getConnection();

        List<String> keys = this.getAllKeys(cacheName);

        try {
            for (String key: keys
                 ) {
                String cacheKey = SerializeUtil.serialize(key);

                if (jedis.hexists(cacheName, cacheKey)) {
                    jedis.hdel(cacheName, cacheKey);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void shutDownCache() {

    }
}
