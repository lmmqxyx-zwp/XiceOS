package top.by.xiceos.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * <p>Title: CollectionUtil</p>
 * <p>Description: 集合工具</p>
 *
 * @author zwp
 * @date 2018/10/19 11:56
 */
public class CollectionUtil {

    /**
     * 判断 collection 为空
     *
     * @param collection 集合
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断 collection 不为空
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断 map 为空
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * 判断 map 不为空
     *
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

}
