package top.by.xiceos.util;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <p>Title: PropertiesUtilTest</p>
 * <p>Description: PropertiesUtil测试类</p>
 *
 * @author zwp
 * @date 2018/10/10 18:14
 */
public class PropertiesUtilTest {

    /**
     * 测试获取XiceOS中默认的模块配置文件路径
     */
    @Test
    public void getAllXiceOSDefaultConfigPathTest() {
        Map<String, String> map = PropertiesUtil.getInstance().getAllXiceOSDefaultConfigPath();

        if (XiceOSUtil.isNotNull(map)) {
            Set<String> keys = map.keySet();

            for (String key: keys
                 ) {
                System.out.println("key: " + key + " => val: " + map.get(key));
            }
        }

        System.out.println("===");
        System.out.println(map);
    }

    /**
     * 测试获取自身模块的主配置文件
     */
    @Test
    public void getXiceOSConfigByModuleNameTest() {
        Properties properties = PropertiesUtil.getInstance().getXiceOSConfigByModuleName("xiceos-core");
        System.out.println(properties);
    }

    /**
     * 测试Properties文件转换成Map
     */
    @Test
    public void propertiesToMapTest() {
        Map<String, Object> map = PropertiesUtil.getInstance().propertiesToMap(PropertiesUtil.getInstance().getXiceOSConfigByModuleName("xiceos-core"));

        System.out.println(map);
    }

}
