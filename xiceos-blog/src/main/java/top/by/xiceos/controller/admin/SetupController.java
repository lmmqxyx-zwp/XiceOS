package top.by.xiceos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: SetupController</p>
 * <p>Description: 设置</p>
 *
 * @author zwp
 * @date 2018/12/20 12:06
 */
@Controller
@RequestMapping(value = "/admin/setup")
public class SetupController {

    /* 评论 */
    private static final String VIEW_DISCUSSION = "admin/setup/discussion";
    /* 基本 */
    private static final String VIEW_GENERAL    = "admin/setup/general";
    /* 永久链接 */
    private static final String VIEW_PERMALINK  = "admin/setup/permalink";
    /* 阅读 */
    private static final String VIEW_READING    = "admin/setup/reading";

    @RequestMapping(value = "/discussion", method = RequestMethod.GET)
    public ModelAndView discussion() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_DISCUSSION);

        return mv;
    }

    @RequestMapping(value = "/general", method = RequestMethod.GET)
    public ModelAndView general() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_GENERAL);

        return mv;
    }

    @RequestMapping(value = "/permalink", method = RequestMethod.GET)
    public ModelAndView permalink() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_PERMALINK);

        return mv;
    }

    @RequestMapping(value = "/reading", method = RequestMethod.GET)
    public ModelAndView reading() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_READING);

        return mv;
    }

}