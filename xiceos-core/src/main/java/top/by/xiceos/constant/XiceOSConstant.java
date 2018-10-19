package top.by.xiceos.constant;

/**
 * <p>Title: XiceOSConstant</p>
 * <p>Description: 基础常量</p>
 *
 * @author zwp
 * @date 2018/10/10 17:31
 */
public class XiceOSConstant {

    // =================================================================================================================
    // 模块注册
    // TODO 日期：2018-10-19 核心core模块中配置有些问题
    public static final String XICEOS_CORE      = "xiceos-core";
    public static final String XICEOS_DB        = "xiceos-db";
    public static final String XICEOS_CACHE     = "xiceos-cache";
    public static final String XICEOS_GENERATOR = "xiceos-generator";

    // =================================================================================================================
    // 默认模块配置文件路径设置
    public static final String XICEOS_CORE_PROPERTIES_PATH      = "/xiceos-core.properties";
    public static final String XICEOS_DB_PROPERTIES_PATH        = "/xiceos-db.properties";
    public static final String XICEOS_CACHE_PROPERTIES_PATH     = "/xiceos-cache.properties";
    public static final String XICEOS_GENERATOR_PROPERTIES_PATH = "/xiceos-generator.properties";

    // =================================================================================================================
    // 默认初始化
    public static final Object _NULL = null;
    public static final String _NULL_STRING = "";
    public static final double _DEFAULT_DOUBLE = 0D;
    public static final float _DEFAULT_FLOAT = 0F;
    public static final int _DEFAULT_INT = 0;
    public static final long _DEFAULT_LONG = 0L;
    public static final boolean _DEFAULT_BOOLEAN = false;

    // =================================================================================================================
    // 缓存模块
    // 缓存类型
    public static final String XICEOS_CACHE_TYPE_REDIS = "redis";

    // 缓存模式
    public static final String XICEOS_CACHE_MODE_SINGLE = "single";

}
