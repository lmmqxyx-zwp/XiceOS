package top.by.xiceos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.by.xiceos.form.LoginUser;

/**
 * <p>Title: LoginController</p>
 * <p>Description: 登录控制器</p>
 *
 * @author zwp
 * @date 2018/12/14 15:39
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String login(@ModelAttribute LoginUser loginUser) {

        return "admin/index";
    }

}
