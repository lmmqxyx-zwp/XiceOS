package top.by.xiceos;

import top.by.xiceos.cache.XiceOSCache;
import top.by.xiceos.cache.redis.RedisClientSingle;
import top.by.xiceos.config.XiceOSCacheConfig;
import top.by.xiceos.constant.XiceOSConstant;
import top.by.xiceos.util.PropertiesUtil;

import java.util.Map;
import java.util.Properties;

/**
 * <p>Title: XiceOSCacheFactory</p>
 * <p>Description: 缓存工厂</p>
 *
 * @author zwp
 * @date 2018/10/11 11:07
 */
public class XiceOSCacheFactory {

    /**
     * 是否启用缓存
     */
    private String cacheEnabled;

    /**
     * 缓存类型
     */
    private String cacheType;

    /**
     * 缓存模式
     */
    private String cacheMode;

    /**
     * 缓存默认命名空间
     */
    private String cacheDefaultName;

    private static volatile XiceOSCacheFactory factory;

    private XiceOSCacheFactory() {
        initFactory();
    }

    /**
     * 获取一个单例类
     *
     * @return
     */
    public static XiceOSCacheFactory getInstance() {
        if (factory == null) {
            synchronized (XiceOSCacheFactory.class) {
                if (factory == null) {
                    factory = new XiceOSCacheFactory();
                }
            }
        }
        return factory;
    }

    /**
     * 初始化工厂
     */
    private void initFactory() {
        Properties properties = (Properties) new XiceOSCacheConfig().getModuleConfig((String) XiceOSConstant._NULL);

        this.setCacheEnabled((String) properties.get("xiceos.cache.enabled"));
        this.setCacheType((String) properties.get("xiceos.cache.type"));
        this.setCacheMode((String) properties.get("xiceos.cache.mode"));
        this.setCacheDefaultName((String) properties.get("xiceos.cache.default.name"));
    }

    /**
     * 获取缓存管理器
     *
     * @return
     */
    public XiceOSCache getXiceOSCache() {
        XiceOSCache xiceOSCache = (XiceOSCache) XiceOSConstant._NULL;

        // redis 缓存
        if (XiceOSConstant.XICEOS_CACHE_TYPE_REDIS.equals(this.getCacheType())) {

            // 单机模式
            if (XiceOSConstant.XICEOS_CACHE_MODE_SINGLE.equals(this.getCacheMode())) {
                xiceOSCache = this.getRedisClientSingle();
            }

            // TODO 其他模式
        }

        // TODO 其他缓存类型

        return xiceOSCache;
    }

    /**
     * 获取redis单机模式操作类
     *
     * @return
     */
    private XiceOSCache getRedisClientSingle() {
        return RedisClientSingle.getInstance();
    }

    public String getCacheEnabled() {
        return cacheEnabled;
    }

    public void setCacheEnabled(String cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }

    public String getCacheType() {
        return cacheType;
    }

    public void setCacheType(String cacheType) {
        this.cacheType = cacheType;
    }

    public String getCacheMode() {
        return cacheMode;
    }

    public void setCacheMode(String cacheMode) {
        this.cacheMode = cacheMode;
    }

    public String getCacheDefaultName() {
        return cacheDefaultName;
    }

    public void setCacheDefaultName(String cacheDefaultName) {
        this.cacheDefaultName = cacheDefaultName;
    }
}
