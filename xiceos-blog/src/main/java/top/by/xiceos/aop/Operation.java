package top.by.xiceos.aop;

import java.lang.annotation.*;

/**
 * <p>Title: Operation</p>
 * <p>Description: 日志操作注解</p>
 *
 * @author zwp
 * @date 2018/12/26 11:40
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Operation {
    /**
     * 操作类型
     *
     * @return
     */
    OperationType type();

    /**
     * 操作描述
     *
     * @return
     */
    String desc() default "";

    /**
     * 参数描述
     *
     * @return
     */
    String[] argsDesc() default {};
}
