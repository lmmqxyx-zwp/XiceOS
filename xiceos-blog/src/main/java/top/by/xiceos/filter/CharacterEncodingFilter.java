package top.by.xiceos.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * <p>Title: CharacterEncodingFilter</p>
 * <p>Description: 字符编码过滤器</p>
 *
 * @author zwp
 * @date 2018/12/13 12:11
 */
public class CharacterEncodingFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(CharacterEncodingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("使用xblog字符编码过滤器");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}