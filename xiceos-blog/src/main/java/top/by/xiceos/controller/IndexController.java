package top.by.xiceos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.by.xiceos.aop.Token;
import top.by.xiceos.api.ApiResponseData;
import top.by.xiceos.service.UsersService;
import top.by.xiceos.vo.Users;

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

    @Autowired
    private UsersService usersService;

    @RequestMapping(path = {"/", "test"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("待多语言整改主页");
        logger.info(messageSource.getMessage("xblog.controller.index", new Object[]{new Date(), "xBlog后台"}, LocaleContextHolder.getLocale()));
        // Users users = new Users();
        // users.setUsername(new Long(System.currentTimeMillis()).toString());
        // int count = usersService.addUsers(users);
        // logger.info("插入数据：" + count);
        // ApiResponseData data = usersService.getPages(3, 4);
        // logger.info(request.getSession().getAttribute("token").toString());
        // System.out.println(10/0);
        return "index";
    }

    /**
     * (http://127.0.0.1:8080/xblog/add?username=qq2&token=91153b72-ab09-4832-876d-a7f77f7a87a0)
     *
     * @param users
     * @param request
     * @return
     */
    @Token(remove = true)
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponseData add(@ModelAttribute Users users, HttpServletRequest request) {
        return usersService.insert(users);
    }

    /**
     * (http://127.0.0.1:8080/xblog/del?id=50&token=b1705f73-e358-4ec4-b031-531e1cd4f3f6)
     *
     * @param id
     * @param request
     * @return
     */
    @Token(remove = true)
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ApiResponseData del(@RequestParam(name = "id") String id, HttpServletRequest request) {
        return usersService.delete(Long.valueOf(id));
    }

    @Token(remove = true)
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResponseData edit(@ModelAttribute Users users, HttpServletRequest request) {
        return usersService.update(users);
    }

    /**
     * (http://127.0.0.1:8080/xblog/search/50)
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public ApiResponseData search(@PathVariable String id) {
        return usersService.findById(Long.valueOf(id));
    }

    /**
     * 注意传参(http://127.0.0.1:8080/xblog/searchIds?ids=50&ids=51&ids=52)
     *
     * @param strIds 主键ID的集合
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchIds", method = RequestMethod.GET)
    public ApiResponseData search(@RequestParam(value = "ids") String[] strIds) {
        Long[] ids = new Long[strIds.length];
        for (int i = 0; i < strIds.length; i++) {
            ids[i] = Long.valueOf(strIds[i]);
        }
        return usersService.findByIds(ids);
    }

    /**
     * (http://127.0.0.1:8080/xblog/searchAll)
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public ApiResponseData search() {
        return usersService.findAll();
    }

    /**
     * (http://127.0.0.1:8080/xblog/pages?pageNum=1&pageSize=11)
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    public ApiResponseData search(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize
    ) {
        return usersService.getPages(pageNum, pageSize);
    }

}
