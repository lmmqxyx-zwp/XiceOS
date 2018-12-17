package top.by.xiceos.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.by.xiceos.aop.Token;
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

    @Token(remove = true)
    @RequestMapping(path = {"/", "test"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("待多语言整改主页");
        logger.info(messageSource.getMessage("xblog.controller.index", new Object[]{new Date(), "xBlog后台"}, LocaleContextHolder.getLocale()));
        // Users users = new Users();
        // users.setUsername(new Long(System.currentTimeMillis()).toString());
        // int count = usersService.addUsers(users);
        // logger.info("插入数据：" + count);
        PageInfo<Users> users = usersService.findAllUsers(3, 4);
        //logger.info(request.getSession().getAttribute("token").toString());
        System.out.println(10/0);
        return "index";
    }

    /**
     * 获取所有用户的分页信息
     *
     * @param pageNum  页码
     * @param pageSize 页数据
     * @return
     */
    @ResponseBody
    @GetMapping("/usersAll")
    public Object findAllUsers(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "4") int pageSize){
        return usersService.findAllUsers(pageNum, pageSize);
    }


    @ResponseBody
    @GetMapping("/users")
    public Users findUsers(@ModelAttribute Users users) {
        return usersService.findUsers(users);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "home/index";
    }

}
