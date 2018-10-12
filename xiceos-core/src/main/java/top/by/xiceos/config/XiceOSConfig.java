package top.by.xiceos.config;

/**
 * <p>Title: XiceOSConfig</p>
 * <p>Description: 项目配置文件接口</p>
 *
 * @author zwp
 * @date 2018/10/9 16:25
 */
public interface XiceOSConfig {

    /**
     * 获取项目配置
     *
     * @param path 配置文件路径
     * @return
     */
    Object getModuleConfig(String path);
}
