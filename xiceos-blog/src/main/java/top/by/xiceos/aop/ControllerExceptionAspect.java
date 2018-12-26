package top.by.xiceos.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.by.xiceos.api.ApiResponseData;

/**
 * <p>Title: ControllerExceptionAspect</p>
 * <p>Description:
 *      控制层异常统一处理(处理返回ApiResponseData方法)
 *      Order好像不起作用(越小的越先执行)
 *      设置Order是因为怕Controller会重复调用、其实不会重复调用
 * </p>
 *
 * @author zwp
 * @date 2018/12/26 15:39
 */
@Aspect
@Component
@Order(1)
public class ControllerExceptionAspect {

    private Logger logger = LoggerFactory.getLogger(ControllerExceptionAspect.class);

    @Pointcut("execution(public top.by.xiceos.api.ApiResponseData top.by.xiceos.controller..*.*(..))")
    private void exception() {

    }

    @Around("exception()")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
        ApiResponseData<?> apiResponseData;

        try {
            apiResponseData = (ApiResponseData<?>) pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            apiResponseData = handlerException(pjp, throwable);
        }

        return apiResponseData;
    }

    private ApiResponseData<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ApiResponseData<?> apiResponseData;

        if (e instanceof RuntimeException) {
            logger.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            apiResponseData = ApiResponseData.ofMessage(ApiResponseData.Status.DATA_ORGANIZATION_EXCEPTION.getCode(), e.getMessage());
        } else {
            logger.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            apiResponseData = ApiResponseData.ofMessage(ApiResponseData.Status.DATA_ORGANIZATION_EXCEPTION.getCode(), e.getMessage());
        }

        return apiResponseData;
    }
}
