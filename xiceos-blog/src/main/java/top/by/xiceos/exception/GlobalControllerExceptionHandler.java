package top.by.xiceos.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: GlobalControllerExceptionHandler</p>
 * <p>Description: 异常处理</p>
 *
 * @author zwp
 * @date 2018/12/17 15:46
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    public static final String _500_ = "error/500";

    //@ExceptionHandler(value = Exception.class)
    public ModelAndView _500_ErrorHandler(HttpServletRequest request, Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("exception", e);
        view.addObject("url", request.getRequestURL());
        view.setViewName(_500_);

        return view;
    }

}
