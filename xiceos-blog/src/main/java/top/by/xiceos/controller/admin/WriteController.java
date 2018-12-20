package top.by.xiceos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: WriteController</p>
 * <p>Description: 撰写</p>
 *
 * @author zwp
 * @date 2018/12/20 12:05
 */
@Controller
@RequestMapping(value = "/admin/write")
public class WriteController {

    /* 创建页面 */
    private static final String VIEW_PAGE = "admin/write/page";
    /* 撰写文章 */
    private static final String VIEW_POST = "admin/write/post";

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_PAGE);

        return mv;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView post() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_POST);

        return mv;
    }

}
