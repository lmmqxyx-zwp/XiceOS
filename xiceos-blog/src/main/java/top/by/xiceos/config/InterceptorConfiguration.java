package top.by.xiceos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.by.xiceos.interceptor.LogInterceptor;
import top.by.xiceos.interceptor.LoginInterceptor;

/**
 * <p>Title: InterceptorConfiguration</p>
 * <p>Description: 拦截器统一配置类</p>
 *
 * @author zwp
 * @date 2018/12/13 11:02
 */
@Configuration
public class InterceptorConfiguration {

    @Autowired
    private Environment env;

    /** 日志拦截器 */
    @Autowired
    private LogInterceptor logInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Bean
    public WebMvcConfigurer addLogInterceptor() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(logInterceptor).addPathPatterns("/**").order(1);
            }
        };
    }

    @Bean
    public WebMvcConfigurer addLoginInterceptor() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**").order(2);
            }
        };
    }

}
