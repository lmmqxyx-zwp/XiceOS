package top.by.xiceos.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: LogInterceptor</p>
 * <p>Description: 日志拦截器实现，对于日志的记录肯定是操作完成结束后才记录，若是在操作没有全部完成的时候就进行日志的记录，那么就会记录一
 * 些垃圾日志，比如在处理数据库的时候失败了，发生了异常，那此时的日志时不需要记录的。</p>
 *
 * @author zwp
 * @date 2018/12/13 14:30
 */
@Component
public class LogInterceptor implements BlogInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        this.logger.info("请求路径：{}", request.getRequestURI());
    }
}
