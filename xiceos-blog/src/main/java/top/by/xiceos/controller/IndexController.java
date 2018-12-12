package top.by.xiceos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: IndexController</p>
 * <p>Description: xblog前台主页控制器</p>
 *
 * @author zwp
 * @date 2018/12/12 17:12
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("待多语言整改主页");
        return "index";
    }

}
