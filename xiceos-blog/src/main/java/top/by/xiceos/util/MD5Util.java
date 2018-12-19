package top.by.xiceos.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <p>Title: MD5Util</p>
 * <p>Description: MD5工具</p>
 *
 * @author zwp
 * @date 2018/12/19 16:39
 */
public class MD5Util {
    /**
     * 加密
     *
     * @param plaintext 明文
     * @param key       密钥
     * @return 密文
     */
    public static String md5(String plaintext, String key) {
        return DigestUtils.md5Hex(plaintext + key);
    }

    /**
     * 验证
     *
     * @param plaintext 明文
     * @param key       密钥
     * @param md5       密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String plaintext, String key, String md5) {
        return md5(plaintext, key).equalsIgnoreCase(md5);
    }
}