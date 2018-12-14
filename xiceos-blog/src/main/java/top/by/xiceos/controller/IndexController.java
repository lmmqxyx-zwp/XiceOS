package top.by.xiceos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p>Title: IndexController</p>
 * <p>Description: 安装与主页的控制器</p>
 *
 * @author zwp
 * @date 2018/12/12 17:12
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(path = {"/", "test"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("待多语言整改主页");
        logger.info(messageSource.getMessage("xblog.controller.index", new Object[]{new Date(), "xBlog后台"}, LocaleContextHolder.getLocale()));
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "home/index";
    }

}
