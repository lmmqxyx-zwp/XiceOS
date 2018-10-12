package top.by.xiceos.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: Test</p>
 * <p>Description: XiceOS 测试实体</p>
 *
 * <p>
 *     缓存测试
 *     数据映射测试
 * </p>
 *
 * @author zwp
 * @date 2018/10/9 16:06
 */
public class Test implements Serializable {

    /**
     * 八种基本数据类型
     */

    private byte    t1;
    private short   t2;
    private int     t3;
    private long    t4;

    private boolean t5;

    private float   t6;
    private double  t7;

    private char    t8;

    private Date    t9;

    public byte getT1() {
        return t1;
    }

    public void setT1(byte t1) {
        this.t1 = t1;
    }

    public short getT2() {
        return t2;
    }

    public void setT2(short t2) {
        this.t2 = t2;
    }

    public int getT3() {
        return t3;
    }

    public void setT3(int t3) {
        this.t3 = t3;
    }

    public long getT4() {
        return t4;
    }

    public void setT4(long t4) {
        this.t4 = t4;
    }

    public boolean isT5() {
        return t5;
    }

    public void setT5(boolean t5) {
        this.t5 = t5;
    }

    public float getT6() {
        return t6;
    }

    public void setT6(float t6) {
        this.t6 = t6;
    }

    public double getT7() {
        return t7;
    }

    public void setT7(double t7) {
        this.t7 = t7;
    }

    public char getT8() {
        return t8;
    }

    public void setT8(char t8) {
        this.t8 = t8;
    }

    public Date getT9() {
        return t9;
    }

    public void setT9(Date t9) {
        this.t9 = t9;
    }
}
