package top.by.xiceos.config;

import top.by.xiceos.constant.XiceOSConstant;
import top.by.xiceos.util.PropertiesUtil;
import top.by.xiceos.util.XiceOSUtil;

import java.util.Properties;

/**
 * <p>Title: XiceOSDBConfig</p>
 * <p>Description: 对应配置xiceos-db.properties文件</p>
 *
 * @author zwp
 * @date 2018/10/9 16:12
 */
public class XiceOSDbConfig implements XiceOSConfig {

    private Properties properties;

    /**
     * 初始化配置
     *
     * @param path 配置文件路径、若没有传path参数则使用默认配置参数
     */
    private void initConfig(String path) {
        String configPath = XiceOSConstant.XICEOS_DB_PROPERTIES_PATH;

        if (XiceOSUtil.isNotNull(path)) {
            configPath = path;
        }

        this.properties = PropertiesUtil.getInstance().loadProperties(configPath);
    }

    @Override
    public Object getModuleConfig(String path) {
        if (XiceOSUtil.isNull(this.properties)) {
            initConfig(path);
        }

        return this.properties;
    }
}
