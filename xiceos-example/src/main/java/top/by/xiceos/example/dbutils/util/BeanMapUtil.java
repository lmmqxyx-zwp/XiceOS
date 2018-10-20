package top.by.xiceos.example.dbutils.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: BeanMapUtil</p>
 * <p>Description: 实体和Map类型之间的相互转换</p>
 *
 * @author zwp
 * @date 2018/10/20 14:34
 */
public class BeanMapUtil {

    /**
     * Map转换成对象
     *
     * @param map       Map类型
     * @param beanClass 实体类型
     * @param <T> 转换对象类型
     * @return
     * @throws Exception
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) {
        try {
            Object o = beanClass.newInstance();
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }

                field.setAccessible(true);
                field.set(o, map.get(field.getName()));
            }

            return (T) o;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对象转换成Map
     *
     * @param o       实体
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object o) throws Exception {
        if (o == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<>();

        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(o));
        }

        return map;
    }

}
