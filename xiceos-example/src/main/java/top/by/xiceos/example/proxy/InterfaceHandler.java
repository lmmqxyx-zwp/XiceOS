package top.by.xiceos.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>Title: InterfaceHandler</p>
 * <p>Description: 代理助手类</p>
 *
 * @author zwp
 * @date 2018/10/19 17:02
 */
public class InterfaceHandler implements InvocationHandler {

    /**
     * 名称
     */
    private String name;

    /**
     * 版本
     */
    private int version;

    /**
     * 执行方法
     *
     * @param proxy     代理对象实例
     * @param method    执行的方法
     * @param args      执行方法的参数
     * @return          返回值为执行方法对应的返回值，需要注意的是如果有返回值的地方没有返回值，那么将会出现空指针异常
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        Object result = null;

        if ("initialize".equals(methodName)) {
            if (args != null && args.length == 2) {

                this.name = (String) args[0];
                this.version = (Integer) args[1];

                result = Boolean.TRUE;
            } else {
                result = Boolean.FALSE;
            }
        }

        if ("getEntity".equals(methodName)) {
            if (this.name == null && this.version < 0) {
                throw new Exception("请先执行 initialize 初始化、并且version为正整数");
            }

            // TODO 业务处理
            result = new Entity();
        }


        return result;
    }
}
