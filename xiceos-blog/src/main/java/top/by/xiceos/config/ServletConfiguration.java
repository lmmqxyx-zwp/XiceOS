package top.by.xiceos.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: ServletConfiguration</p>
 * <p>Description: druid配置</p>
 *
 * @author zwp
 * @date 2018/12/17 15:42
 */
@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        // 禁用HTML页面上的“Rest All”功能
        initParameters.put("resetEnable", "false");
        // ip白名单（没有配置或者为空，则允许所有访问）
        initParameters.put("allow", "127.0.0.1");
        // 监控页面登录用户名
        initParameters.put("loginUsername", "admin");
        // 监控页面登录用户密码
        initParameters.put("loginPassword", "admin");
        // ip黑名单 如果某个ip同时存在，deny优先于allow
        initParameters.put("deny", "");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

}
