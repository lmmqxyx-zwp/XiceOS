package top.by.xiceos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: ManagerController</p>
 * <p>Description: 管理</p>
 *
 * @author zwp
 * @date 2018/12/20 12:05
 */
@Controller
@RequestMapping(value = "/admin/manager")
public class ManagerController {

    /* 分类 */
    private static final String VIEW_CATEGORIES = "admin/manager/categories";
    /* 评论 */
    private static final String VIEW_COMMENTS   = "admin/manager/comments";
    /* 文件 */
    private static final String VIEW_MEDIAS     = "admin/manager/medias";
    /* 独立页面 */
    private static final String VIEW_PAGES      = "admin/manager/pages";
    /* 文章 */
    private static final String VIEW_POSTS      = "admin/manager/posts";
    /* 标签 */
    private static final String VIEW_TAGS       = "admin/manager/tags";
    /* 用户 */
    private static final String VIEW_USERS      = "admin/manager/users";

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView categories() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_CATEGORIES);

        return mv;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ModelAndView comments() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_COMMENTS);

        return mv;
    }

    @RequestMapping(value = "/medias", method = RequestMethod.GET)
    public ModelAndView medias() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_MEDIAS);

        return mv;
    }

    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    public ModelAndView pages() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_PAGES);

        return mv;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView posts() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_POSTS);

        return mv;
    }

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public ModelAndView tags() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_TAGS);

        return mv;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView users() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_USERS);

        return mv;
    }

}