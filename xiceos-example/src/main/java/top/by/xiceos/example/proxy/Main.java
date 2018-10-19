package top.by.xiceos.example.proxy;

import java.lang.reflect.Proxy;

/**
 * <p>Title: Main</p>
 * <p>Description: 主函数</p>
 *
 * @author zwp
 * @date 2018/10/19 17:00
 */
public class Main {

    public void invoke() {
        try {
            Class<?> cls = Class.forName("top.by.xiceos.example.proxy.Interface");

            Interface i = (Interface) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[] { cls }, new InterfaceHandler());

            boolean b = i.initialize("冰羽", 1);

            System.out.println(b);

            Entity e = i.getEntity();

            System.out.println(e);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Main().invoke();

    }

}
