package top.by.xiceos.util;

import top.by.xiceos.constant.XiceOSConstant;

/**
 * <p>Title: CastUtil</p>
 * <p>Description: 转型工具</p>
 *
 * @author zwp
 * @date 2018/10/19 11:15
 */
public class CastUtil {

    /**
     * 转换为java.lang.String类型
     *
     * @param o 待转换类型
     * @return 空对象转换成空串
     */
    public static String castString(Object o) {
        return castString(o, XiceOSConstant._NULL_STRING);
    }

    /**
     * 转换为java.lang.String类型
     *
     * @param o             待转换类型
     * @param defaultValue  默认值
     * @return 空对象转换成defaultValue
     */
    public static String castString(Object o, String defaultValue) {
        return XiceOSUtil.isNotNull(o) ? String.valueOf(o) : defaultValue;
    }

    /**
     * 转换为double类型
     *
     * @param o 待转换类型
     * @return
     */
    public static double castDouble(Object o) {
        return castDouble(o, XiceOSConstant._DEFAULT_DOUBLE);
    }

    /**
     * 转换为double类型
     *
     * @param o             待转换类型
     * @param defaultValue  默认值
     * @return
     */
    public static double castDouble(Object o, double defaultValue) {
        double value = defaultValue;

        if (XiceOSUtil.isNotNull(o)) {
            String s = castString(o);

            if (XiceOSUtil.isNotEmpty(s)) {
                try {
                    value = Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }

        return value;
    }

    /**
     * 转换为float类型
     *
     * @param o 待转换类型
     * @return
     */
    @Deprecated
    public static float castFloat(Object o) {
        return castFloat(o, XiceOSConstant._DEFAULT_FLOAT);
    }

    /**
     * 转换为float类型
     *
     * @param o             待转换类型
     * @param defaultValue  默认值
     * @return
     */
    @Deprecated
    public static float castFloat(Object o, float defaultValue) {
        float value = defaultValue;

        if (XiceOSUtil.isNotNull(o)) {
            String s = castString(o);

            if (XiceOSUtil.isNotEmpty(s)) {
                try {
                    value = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }

        return value;
    }

    /**
     * 转换为int类型
     *
     * @param o 待转换类型
     * @return
     */
    public static int castInt(Object o) {
        return castInt(o, XiceOSConstant._DEFAULT_INT);
    }

    /**
     * 转换为int类型
     *
     * @param o             待转换类型
     * @param defaultValue  默认值
     * @return
     */
    public static int castInt(Object o, int defaultValue) {
        int value = defaultValue;

        if (XiceOSUtil.isNotNull(o)) {
            String s = castString(o);

            if (XiceOSUtil.isNotEmpty(s)) {
                try {
                    value = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }

        return value;
    }

    /**
     * 转换为long类型
     *
     * @param o 待转换类型
     * @return
     */
    public static long castLong(Object o) {
        return castLong(o, XiceOSConstant._DEFAULT_LONG);
    }

    /**
     * 转换为long类型
     *
     * @param o             待转换类型
     * @param defaultValue  默认值
     * @return
     */
    public static long castLong(Object o, long defaultValue) {
        long value = defaultValue;

        if (XiceOSUtil.isNotNull(o)) {
            String s = castString(o);

            if (XiceOSUtil.isNotEmpty(s)) {
                try {
                    value = Long.parseLong(s);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }

        return value;
    }

    /**
     * 转换为boolean类型
     *
     * @param o 待转换类型
     * @return
     */
    public static boolean castBoolean(Object o) {
        return castBoolean(o, XiceOSConstant._DEFAULT_BOOLEAN);
    }

    /**
     * 转换为boolean类型
     *
     * @param o             待转换类型
     * @param defaultValue  默认值
     * @return
     */
    public static boolean castBoolean(Object o, boolean defaultValue) {
        boolean value = defaultValue;

        if (XiceOSUtil.isNotNull(o)) {
            String s = castString(o);

            if (XiceOSUtil.isNotEmpty(s)) {
                try {
                    value = Boolean.parseBoolean(s);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }

        return value;
    }

}
