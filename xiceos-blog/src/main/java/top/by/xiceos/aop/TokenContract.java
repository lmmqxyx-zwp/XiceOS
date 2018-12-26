package top.by.xiceos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import top.by.xiceos.exception.FormRepeatException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <p>Title: TokenContract</p>
 * <p>Description: 防止表单重复提交</p>
 *
 * @author zwp
 * @date 2018/12/17 11:29
 */
@Aspect
@Component
public class TokenContract {

    /* token 键 */
    public static final String TOKEN_KEY = "token";

    @Autowired
    private MessageSource messageSource;

    @Before("within(@org.springframework.stereotype.Controller *) && @annotation(token)")
    public void token(final JoinPoint joinPoint, Token token) throws Exception {
        if (token != null) {
            // 获取joinPoint的全部参数
            // 切入点的参数，即controller的方法的形参
            // 如果是只有接受对象的参数的方法，那么没有request时将会取不到session的值 => 空指针
            Object[] args = joinPoint.getArgs();

            HttpServletRequest request = null;
            HttpServletResponse response = null;

            for (int i = 0; i < args.length; i++) {
                // 获取参数中的request和response
                if (args[i] instanceof HttpServletRequest) {
                    request = (HttpServletRequest) args[i];
                }

                if (args[i] instanceof HttpServletResponse) {
                    response = (HttpServletResponse) args[i];
                }
            }

            boolean setToken = token.setToken();

            if (setToken) {
                String uuid = UUID.randomUUID().toString();
                // 获取token存于session
                request.getSession().setAttribute(TOKEN_KEY, uuid);
            }

            boolean remove = token.remove();

            if (remove) {
                try {
                    boolean isRepeat = isRepeatSubmit(request);
                    if (isRepeat) {
                        throw new FormRepeatException(messageSource.getMessage(
                                "xblog.aop.log.token.message",
                                new Object[]{},
                                LocaleContextHolder.getLocale())
                        );
                    }
                } catch (FormRepeatException e) {
                    throw new Exception(e);
                }

                if (request.getSession(false) != null) {
                    request.getSession(false).removeAttribute(TOKEN_KEY);
                }
            }
        }
    }

    /**
     * 判断是否重复提交表单
     *
     * @param request 请求
     * @return
     * @throws FormRepeatException
     */
    private boolean isRepeatSubmit(HttpServletRequest request) throws FormRepeatException {
        // 判断时候获取过token值，若没有获取过token值则session为NULL
        if (request.getSession(false) == null) {
            throw new FormRepeatException(messageSource.getMessage(
                    "xblog.aop.log.token.session.message",
                    new Object[]{},
                    LocaleContextHolder.getLocale())
            );
        }

        String token = (String) request.getSession(false).getAttribute(TOKEN_KEY);

        if (token == null) {
            return true;
        }

        String clientToken = request.getParameter(TOKEN_KEY);

        if (clientToken == null || "".equals(clientToken)) {
            return true;
        }

        if (!token.equals(clientToken)) {
            throw new FormRepeatException(messageSource.getMessage(
                    "xblog.aop.log.token.message",
                    new Object[]{},
                    LocaleContextHolder.getLocale())
            );
        }

        return false;
    }

}
