package top.by.xiceos.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import top.by.xiceos.constant.XiceOSConstant;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <p>Title: PropertiesUtil</p>
 * <p>Description: 处理.properties文件工具</p>
 *
 * @author zwp
 * @date 2018/10/10 10:31
 */
public final class PropertiesUtil {

    /**
     * 默认配置文件路径信息
     */
    private Map<String, String> DEFAULT_XICEOS_CONDIF_PATH;

    /**
     * 线程副本
     */
    private ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();

    private static volatile PropertiesUtil util;

    private PropertiesUtil() {
        initDefaultXiceosConfigPath();
    }

    /**
     * 初始化配置文件路径信息
     * 注册相关模块配置
     */
    private void initDefaultXiceosConfigPath() {

        if (XiceOSUtil.isNull(this.DEFAULT_XICEOS_CONDIF_PATH)) {
            this.DEFAULT_XICEOS_CONDIF_PATH = new HashMap<String, String>();

            this.DEFAULT_XICEOS_CONDIF_PATH.put(XiceOSConstant.XICEOS_CORE,      XiceOSConstant.XICEOS_CORE_PROPERTIES_PATH);
            this.DEFAULT_XICEOS_CONDIF_PATH.put(XiceOSConstant.XICEOS_DB,        XiceOSConstant.XICEOS_DB_PROPERTIES_PATH);
            this.DEFAULT_XICEOS_CONDIF_PATH.put(XiceOSConstant.XICEOS_CACHE,     XiceOSConstant.XICEOS_CACHE_PROPERTIES_PATH);
            this.DEFAULT_XICEOS_CONDIF_PATH.put(XiceOSConstant.XICEOS_GENERATOR, XiceOSConstant.XICEOS_GENERATOR_PROPERTIES_PATH);
        }

        threadLocal.set(this.DEFAULT_XICEOS_CONDIF_PATH);
    }

    /**
     * 获取一个单例类
     *
     * @return
     */
    public static PropertiesUtil getInstance() {
        if (util == null) {
            synchronized (PropertiesUtil.class) {
                if (util == null) {
                    util = new PropertiesUtil();
                }
            }
        }
        return util;
    }

    /**
     * 获取默认的XiceOS各个模块的全部配置文件数据
     *
     * @return
     */
    public Map<String, String> getAllXiceOSDefaultConfigPath() {

        if (XiceOSUtil.isNull(this.threadLocal.get())) {
            initDefaultXiceosConfigPath();

            this.threadLocal.set(this.DEFAULT_XICEOS_CONDIF_PATH);
        }

        return this.threadLocal.get();
    }

    // =================================================================================================================
    // spring 加载配置文件
    /**
     * 根据模块名称获取对应的模块著配置文件内容
     *
     * @param moduleName
     * @return
     */
    @Deprecated
    public Properties getXiceOSConfigByModuleName(String moduleName) {
        Properties properties = (Properties) XiceOSConstant._NULL;

        try {
            Resource resource = new ClassPathResource(this.getAllXiceOSDefaultConfigPath().get(moduleName));
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * 获取依赖包中的properties配置文件
     *
     * @param moduleName
     * @return
     */
    public Properties getDependencyXiceOSConfigByModuleName(String moduleName) {
        return this.loadProperties(this.getAllXiceOSDefaultConfigPath().get(moduleName));
    }

    /**
     * 加载properties配置文件
     *
     * @param path
     * @return
     */
    public Properties loadProperties(String path) {
        Properties properties = (Properties) XiceOSConstant._NULL;

        try {
            InputStream inputStream = this.getClass().getResourceAsStream(path);

            if (XiceOSUtil.isNotNull(inputStream)) {
                properties = new Properties();
                properties.load(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * Properties文件内容转换成Map
     *
     * @param properties
     * @return
     */
    public Map<String, Object> propertiesToMap(Properties properties) {
        Map<String, Object> map = new HashMap<String, Object>((Map) properties);

        // Set<Map.Entry<String, Object>> entryKeys = map.entrySet();
        //
        // for (Object o: entryKeys
        //      ) {
        //     Map.Entry<String, Object> entry = (Map.Entry<String, Object>) o;
        //
        //     System.out.println("key: " + entry.getKey() + " => val: " + entry.getValue());
        // }

        return map;
    }

}
