package top.by.xiceos.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Title: Token</p>
 * <p>Description: Token注解</p>
 *
 * @author zwp
 * @date 2018/12/17 11:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Token {

    /**
     * 设置token值
     *
     * @return
     */
    boolean setToken() default false;

    /**
     * 移出token值
     *
     * @return
     */
    boolean remove() default false;
}
