package top.by.xiceos.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: BlogInterceptor</p>
 * <p>Description: xBlog父接口</p>
 *
 * @author zwp
 * @date 2018/12/13 15:06
 */
public interface BlogInterceptor extends HandlerInterceptor {

    /**
     * 预处理回调方法，在controller之前执行实现处理器的预处理操作
     *
     * @param request  请求
     * @param response 响应
     * @param handler  响应控制器
     *
     * @return  返回true则继续流程到下一个拦截器或者控制器；
     *          返回false则中断流程，此时不会去调用下一个拦截器或者控制器，需要用response产生响应
     */
    @Override
    default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        return true;
    }

    /**
     * 后处理方法，控制器执行完后执行，但是在视图渲染之前执行，此时可以通过modelAndView对模型数据进行处理或对视图进行处理
     *
     * @param request      请求
     * @param response     响应
     * @param handler      响应控制器
     * @param modelAndView 模型和视图，有可能为空(null)
     */
    @Override
    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * 整个请求处理完毕之后调用，即在视图渲染完毕时回调。例如性能监控中可以在此处记录结束时间并输出消耗时间，还可以进行一些资源的清理(类似
     * 于try-catch-finally中的finally，但仅调用处理器执行链中)；在postHandle执行后面调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
