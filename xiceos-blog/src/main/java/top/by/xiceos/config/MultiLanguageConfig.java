package top.by.xiceos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * <p>Title: MultiLanguageConfig</p>
 * <p>Description: 国际化</p>
 *
 * @author zwp
 * @date 2018/12/14 10:16
 */
@Configuration
public class MultiLanguageConfig implements WebMvcConfigurer {

    /**
     * 添加语言解析器，并设置默认语言为中文。
     * LocaleResolver接口有许多实现，如可以从session、cookie、Accept-Language header、或者一个固定的值来判断当前的语言环境，下面是
     * 使用session来判断。
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认设置为中文SIMPLIFIED_CHINESE 英文为US
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    /**
     * 切换语言过滤器
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
