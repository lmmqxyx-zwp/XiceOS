package top.by.xiceos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * <p>Title: WebLogAspect</p>
 * <p>Description: WEB请求日志</p>
 *
 * @author zwp
 * @date 2018/12/26 12:01
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * top.by.xiceos.controller..*.*(..))")
    private void webLog() {

    }

    @Before("webLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录内容
        logger.info("URL            : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD    : " + request.getMethod());
        logger.info("IP             : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            logger.info("REQUEST_PARAMS : name->{}, value->{}", name, request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void afterx(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE       : " + ret);
    }
}
