package top.by.xiceos.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.by.xiceos.dao.OperationLogDao;
import top.by.xiceos.vo.OperationLog;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title: OperationLogAspect</p>
 * <p>Description: 操作动作日志记录</p>
 *
 * @author zwp
 * @date 2018/12/26 12:01
 */
@Aspect
@Component
@Order(2)
public class OperationLogAspect {

    private Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperationLogDao operationLogDao;

    @Pointcut("@annotation(top.by.xiceos.aop.Operation)")
    private void operationLog() {}

    @Around("operationLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        // 获取签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        Method method = signature.getMethod();

        // 记录日志
        Operation operation = method.getAnnotation(Operation.class);

        // 解析参数
        Object[] args = pjp.getArgs();

        // 方法描述
        String desc = operation.desc();

        // 参数描述
        String[] argsDesc = operation.argsDesc();

        Object result;

        if (args.length == argsDesc.length) {
            // 抽取方法描述
            String paramDesc = this.extractParam(args, argsDesc);

            OperationLog log = new OperationLog();
            Date start = Calendar.getInstance().getTime();
            // 开始执行时间
            logger.info("执行开始时间：" + start);

            // 进入方法前
            result = pjp.proceed();
            // 进入方法后
            Date end   = Calendar.getInstance().getTime();
            // 结束时间
            logger.info("执行结束时间：" + end);
            long time = end.getTime() - start.getTime();
            // 执行时间
            logger.info("执行方法耗时：" + time);

            log.setCreatetime(start);
            log.setDesc(desc);
            log.setResult(result.toString());
            log.setType(operation.type().getName());
            log.setParam(paramDesc);
            log.setIp(request.getRemoteAddr());

            // TODO 用户记录

            operationLogDao.insert(log);
        } else {
            result = pjp.proceed();
            String methodName = signature.getName();
            String className = pjp.getThis().getClass().getName();
            // 去掉cglib代理类标识
            className = className.substring(0, className.indexOf("$$"));
            String errorMessage = "警告：" + methodName + "方法记录日志失败，注解[argsDesc]参数长度与方法实际长度不一致，需要参数[" + args.length + "]个，实际参数[" + argsDesc.length + "]个，请检查：[" + className + "->" + methodName + "]注解！";
            logger.warn(errorMessage);
        }

        return result;
    }

    /**
     * 根据注解参数以及方法实参拼接出方法描述
     *
     * @param args
     * @param arguDesc
     * @return
     */
    private String extractParam(Object[] args, String[] arguDesc) {
        StringBuilder sb = new StringBuilder();
        int size = args.length - 1;
        for (int i = 0; i < arguDesc.length; i++) {
            sb.append(arguDesc[i]+ "->" + args[i] + (i == size ? "" : ", "));
        }
        return sb.toString();
    }

}
