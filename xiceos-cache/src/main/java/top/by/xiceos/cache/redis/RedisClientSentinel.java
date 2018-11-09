package top.by.xiceos.cache.redis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

/**
 * <p>Title: RedisClientSentinel</p>
 * <p>Description: 主从 + 哨兵</p>
 *
 * @author zwp
 * @date 2018/10/31 10:01
 */
public class RedisClientSentinel {
    private static final JedisSentinelPool pool;
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(5);

        Set<String> sentinels = new HashSet<String>(Arrays.asList(
                "192.168.0.70:26379",
                "192.168.0.71:26379",
                "192.168.0.72:26379"));

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(5);
        // 设置配置文件中的redis主节点的名称
        pool = new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig, "14YVeC0PToxRIAs");
    }

    public static void main(String[] args) throws Exception {
        String key1 = "key1";
        try (Jedis jedis = pool.getResource()) {
            jedis.set(key1, "2224");
            System.out.println(jedis.get(key1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
