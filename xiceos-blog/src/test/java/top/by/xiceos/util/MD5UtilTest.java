package top.by.xiceos.util;

import org.junit.Test;

public class MD5UtilTest {

    @Test
    public void md5() {
        System.out.println(MD5Util.md5("admin", "xiceos-blog"));
    }

    @Test
    public void verify() {
        System.out.println(MD5Util.verify("admin", "xiceos-blog", "9a1953f74c96e2ff39b4bf0bc9ea40ce"));
    }
}