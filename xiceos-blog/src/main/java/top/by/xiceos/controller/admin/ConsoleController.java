package top.by.xiceos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: ConsoleController</p>
 * <p>Description: 控制台</p>
 *
 * @author zwp
 * @date 2018/12/20 12:02
 */
@Controller
@RequestMapping(value = "/admin/console")
public class ConsoleController {

    /* 备份 */
    private static final String VIEW_BACKUP  = "admin/console/backup";
    /* 概要 */
    private static final String VIEW_INDEX   = "admin/console/index";
    /* 插件 */
    private static final String VIEW_PLUGINS = "admin/console/plugins";
    /* 个人设置 */
    private static final String VIEW_PROFILE = "admin/console/profile";
    /* 外观 */
    private static final String VIEW_THEMES  = "admin/console/themes";

    @RequestMapping(value = "/backup", method = RequestMethod.GET)
    public ModelAndView backup() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_BACKUP);

        return mv;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_INDEX);

        return mv;
    }

    @RequestMapping(value = "/plugins", method = RequestMethod.GET)
    public ModelAndView plugins() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_PLUGINS);

        return mv;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_PROFILE);

        return mv;
    }

    @RequestMapping(value = "/themes", method = RequestMethod.GET)
    public ModelAndView themes() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_THEMES);

        return mv;
    }

}