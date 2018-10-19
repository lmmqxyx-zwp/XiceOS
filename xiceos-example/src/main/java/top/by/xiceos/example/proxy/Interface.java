package top.by.xiceos.example.proxy;

/**
 * <p>Title: Interface</p>
 * <p>Description: 被代理的接口</p>
 *
 * @author zwp
 * @date 2018/10/19 16:57
 */
public interface Interface {

    /**
     * 简单的显示信息方法
     */
    void display();

    /**
     * 初始化方法
     *
     * @param name      名称
     * @param version   版本
     * @return
     */
    boolean initialize(String name, int version);

    /**
     * 获取一个实体
     *
     * @return
     */
    Entity getEntity();

}
