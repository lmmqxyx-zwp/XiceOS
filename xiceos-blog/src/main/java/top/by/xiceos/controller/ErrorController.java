package top.by.xiceos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Title: ErrorController</p>
 * <p>Description: 错误控制器</p>
 *
 * @author zwp
 * @date 2018/12/14 15:37
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String _403_() {
        return "error/403";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String _404_() {
        return "error/404";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String _500_() {
        return "error/500";
    }

    @RequestMapping(value = "/501", method = RequestMethod.GET)
    public String _501_() {
        return "error/501";
    }
}
