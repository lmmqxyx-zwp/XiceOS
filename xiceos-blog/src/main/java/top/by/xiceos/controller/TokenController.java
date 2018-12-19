package top.by.xiceos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.by.xiceos.aop.Token;
import top.by.xiceos.aop.TokenContract;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: TokenController</p>
 * <p>Description: </p>
 *
 * @author zwp
 * @date 2018/12/17 12:04
 */
@Controller
public class TokenController {

    @Token(setToken = true)
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    @ResponseBody
    public String getToken(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(TokenContract.TOKEN_KEY);
    }
}
