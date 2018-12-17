package top.by.xiceos.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import top.by.xiceos.api.ApiResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>Title: ErrorController</p>
 * <p>Description: 错误控制器</p>
 *
 * @author zwp
 * @date 2018/12/14 15:37
 */
@Controller
public class BlogErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    public BlogErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * WEB页面错误处理
     *
     * @param request    请求
     * @param response   响应
     * @param webRequest 请求
     * @return
     */
    @RequestMapping(value = ERROR_PATH, method = RequestMethod.GET, produces = "text/html")
    public ModelAndView errorPageHandler(HttpServletRequest request, HttpServletResponse response, WebRequest webRequest) {

        ModelAndView view = new ModelAndView();

        int status = response.getStatus();

        // 参数attr中的内容
        // timestamp：异常发生的时间
        // status ：http响应状态码
        // error：异常的名称Exception.getName
        // message:异常的消息getmessage
        // path：发生异常的路由
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(webRequest, false);
        view.addObject("attr", attr);

        switch (status) {
            case 400:
                view.setViewName(ERROR_PATH + "/400");
                break;
            case 404:
                view.setViewName(ERROR_PATH + "/404");
                break;
            case 500:
                view.setViewName(ERROR_PATH + "/500");
                break;
            default:
                view.setViewName(ERROR_PATH + "/undefined");
        }

        return view;
    }

    /**
     * API格式数据异常处理
     *
     * @param request       请求
     * @param e             异常
     * @param webRequest    请求
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ApiResponseData errorApiHandler(HttpServletRequest request, final Exception e, final WebRequest webRequest) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        // log e
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(webRequest, false);

        int status = getStatus(request);

        return ApiResponseData.ofMessage(status, String.valueOf(attr.getOrDefault("message", "error")));
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }

        return 500;
    }

//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public String _403_() {
//        return "error/403";
//    }
//
//    @RequestMapping(value = "/404", method = RequestMethod.GET)
//    public String _404_() {
//        return "error/404";
//    }
//
//    @RequestMapping(value = "/500", method = RequestMethod.GET)
//    public String _500_() {
//        return "error/500";
//    }
//
//    @RequestMapping(value = "/501", method = RequestMethod.GET)
//    public String _501_() {
//        return "error/501";
//    }

}
