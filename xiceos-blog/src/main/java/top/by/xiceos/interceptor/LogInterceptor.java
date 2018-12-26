package top.by.xiceos.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * <p>Title: LogInterceptor</p>
 * <p>Description:
 * 日志拦截器实现，对于日志的记录肯定是操作完成结束后才记录，若是在操作没有全部完成的时候就进行日志的记录，那么就会记录一
 * 些垃圾日志，比如在处理数据库的时候失败了，发生了异常，那此时的日志时不需要记录的。
 * </p>
 *
 * @author zwp
 * @date 2018/12/13 14:30
 */
@Component
public class LogInterceptor implements BlogInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 0.控制器
        String controllerName = "X-BOLG CONTROLLER EXCEPTION";
        // 1.方法名
        String metodName = "X-BOLG METOD EXCEPTION";
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            controllerName = handlerMethod.getBean().getClass().getName();
            metodName = handlerMethod.getMethod().getName();
        }
        // 2.请求路径
        String path = request.getRequestURI();
        // 3.获取参数
        Map<String, String[]> map = request.getParameterMap();
        // x.参数整合 执行速度：StringBuilder > StringBuffer > String
        StringBuilder sb = new StringBuilder();
        Set<String> keys = map.keySet();
        for (String key: keys
             ) {
            String[] val = map.get(key);

            if (val != null) {
                String temp = new String();
                for (int i = 0; i < val.length; i++) {
                    if (i == 0) {
                        if (val.length == 1) {
                            temp = val[i] == null ? "NULL" : val[i];
                        } else {
                            temp += "[ " + val[i] == null ? "NULL" : val[i] + ", ";
                        }
                    } else if (i == val.length - 1) {
                        temp += val[i] == null ? "NULL" : val[i] + " ]";
                    } else {
                        temp += val[i] == null ? "NULL" : val[i] + ", ";
                    }
                }
                sb.append(key + "->" + temp + "; ");
            } else {
                sb.append(key + "->" + "NULL" + "; ");
            }
        }

        if (sb.toString().length() == 0) {
            sb.append("{无参}");
        } else if (sb.toString().length() > 2){
            sb = new StringBuilder("{" + sb.toString().substring(0, sb.toString().length() - 2) + "}");
        }

        this.logger.info(messageSource.getMessage("xblog.interceptor.log.message", new Object[]{controllerName, metodName, path, sb.toString()}, LocaleContextHolder.getLocale()));
    }
}
