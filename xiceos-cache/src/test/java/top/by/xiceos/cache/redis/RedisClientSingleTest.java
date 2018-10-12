package top.by.xiceos.cache.redis;

import org.junit.Test;

import java.util.Date;

/**
 * <p>Title: RedisClientSingleTest</p>
 * <p>Description: 单机模式redis操作测试类</p>
 *
 * @author zwp
 * @date 2018/10/11 21:51
 */
public class RedisClientSingleTest {

    /**
     * 获取连接
     */
    @Test
    public void getConnectionTest() {
        System.out.println(RedisClientSingle.getInstance().getConnection());
    }

    /**
     * 设置
     */
    @Test
    public void setTest() {
        RedisClientSingle.getInstance().set("testCache", "b", "b");
    }

    /**
     * 获取值
     */
    @Test
    public void getTest() {
        System.out.println((String) RedisClientSingle.getInstance().get("testCache", "b"));
    }

    /**
     * 获取全部的键
     */
    @Test
    public void getAllKeysTest() {
        System.out.println(RedisClientSingle.getInstance().getAllKeys("testCache"));
    }

    /**
     * 数据更新
     */
    @Test
    public void updateTest() {
        RedisClientSingle.getInstance().update("testCache", "bc", "bc");
    }

    /**
     * 数据删除
     */
    @Test
    public void removeTest() {
        RedisClientSingle.getInstance().remove("testCache", "bc");
    }

    /**
     * 数据全删
     */
    @Test
    public void removeAllTest() {
        RedisClientSingle.getInstance().removeAll("testCache");
    }

    /**
     * 设置一个对象到缓存
     */
    @Test
    public void setObjectTest() {
        top.by.xiceos.entity.Test test = new top.by.xiceos.entity.Test();
        test.setT3(3);
        test.setT9(new Date());

        RedisClientSingle.getInstance().set("testCache", "Test", test);
    }

    /**
     * 从换从中取得一个对象
     */
    @Test
    public void getObjectTest() {
        top.by.xiceos.entity.Test test = (top.by.xiceos.entity.Test) RedisClientSingle.getInstance().get("testCache", "Test");
        System.out.println(test.getT3());
        System.out.println(test.getT9());
    }

}
