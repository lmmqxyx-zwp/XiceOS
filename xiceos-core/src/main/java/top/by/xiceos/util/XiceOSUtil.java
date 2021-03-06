package top.by.xiceos.util;

/**
 * <p>Title: XiceOSUtil</p>
 * <p>Description: XiceOS基础工具</p>
 *
 * @author zwp
 * @date 2018/10/10 16:57
 */
public class XiceOSUtil {

    /**
     * 判断一个对象为空
     *
     * @param o
     * @return
     */
    public static boolean isNull(Object o) {
        return o == null ? true : false;
    }

    /**
     * 判断一个对象不为空
     *
     * @param o
     * @return
     */
    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    /**
     * 判断一个字符串为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (isNotNull(s)) {
            s = s.trim();
        }

        return (s == null || "".equals(s));
    }

    /**
     * 判断一个字符串不为空
     *
     * @param s
     * @return
     */
    public  static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

}
