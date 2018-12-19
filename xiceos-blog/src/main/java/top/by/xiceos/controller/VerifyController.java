package top.by.xiceos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.by.xiceos.util.VerifyUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * <p>Title: VerifyController</p>
 * <p>Description: 获取验证码</p>
 *
 * @author zwp
 * @date 2018/12/19 16:28
 */
@Controller
public class VerifyController {

    @GetMapping("/verifyCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("verifyCode", objs[0]);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

}
