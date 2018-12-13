package top.by.xiceos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import top.by.xiceos.filter.CharacterEncodingFilter;

/**
 * <p>Title: FilterConfiguration</p>
 * <p>Description: 过滤器统一配置类</p>
 *
 * @author zwp
 * @date 2018/12/13 14:15
 */
@Configuration
public class FilterConfiguration {

    @Autowired
    private Environment env;

    /**
     * 字符编码过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean characterEncodingFilterRegistration() {
        FilterRegistrationBean<CharacterEncodingFilter> registration = new FilterRegistrationBean<CharacterEncodingFilter>();
        registration.setFilter(new CharacterEncodingFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xBlogEncodingFilter");
        registration.setOrder(1);
        return registration;
    }
}
