package top.by.xiceos.util;

/**
 * <p>Title: SerializeUtil</p>
 * <p>Description: 序列化与反序列化工具</p>
 *
 * @author zwp
 * @date 2018/10/11 20:29
 */

import org.apache.shiro.codec.Base64;
import top.by.xiceos.constant.XiceOSConstant;

import java.io.*;

public class SerializeUtil {
    /**
     * 反序列化
     *
     * @param string 待反序列化的字符串
     * @return
     */
    public static Object deserialize(String string) {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            if (XiceOSUtil.isEmpty(string)) {
                return XiceOSConstant._NULL;
            }

            bis = new ByteArrayInputStream(Base64.decode(string));
            ois = new ObjectInputStream(bis);

            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ois);
            close(bis);
        }

        return XiceOSConstant._NULL;
    }

    /**
     * 对象序列化
     *
     * @param obj 待序列化的对象
     * @return
     */
    public static String serialize(Object obj) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(obj);

            return Base64.encodeToString(bos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(oos);
            close(bos);
        }

        return (String) XiceOSConstant._NULL;
    }

    /**
     * 关闭输入流
     *
     * @param i
     */
    private static void close(InputStream i) {
        try {
            if (XiceOSUtil.isNotNull(i)) {
                i.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输出流
     *
     * @param o
     */
    private static void close(OutputStream o) {
        try {
            if (XiceOSUtil.isNotNull(o)) {
                o.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

