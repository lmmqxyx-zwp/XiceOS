package top.by.xiceos.config;

import org.junit.Test;
import top.by.xiceos.util.PropertiesUtil;

import java.util.Properties;

/**
 * <p>Title: XiceOSCacheConfigTest</p>
 * <p>Description: XiceOSCacheConfig缓存配置设置</p>
 *
 * @author zwp
 * @date 2018/10/11 0:32
 */
public class XiceOSCacheConfigTest {

    @Test
    public void getDependencyXiceOSConfigByModuleNameTest() {
        Properties properties = PropertiesUtil.getInstance().getDependencyXiceOSConfigByModuleName("xiceos-db");
        System.out.println(properties);

        properties = PropertiesUtil.getInstance().getXiceOSConfigByModuleName("xiceos-cache");
        System.out.println(properties);
    }

    @Test
    public void getRedisConfigTest() {
        Properties properties = PropertiesUtil.getInstance().loadProperties("/redis/redis.properties");
        System.out.println(properties);
        System.out.println(properties.get("xiceos.redis.single.host"));
        System.out.println(properties.get("xiceos.redis.single.port").getClass().getName());
    }

}
