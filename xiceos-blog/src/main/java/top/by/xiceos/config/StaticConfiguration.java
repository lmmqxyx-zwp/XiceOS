// package top.by.xiceos.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.util.ResourceUtils;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// /**
//  * <p>Title: StaticConfiguration</p>
//  * <p>Description: 加载静态资源配置
//  * 注意：在application.properties中已配置，有默认值的影响导致没有配置的时候也是可以使用的(此处是为了说明也可以使用这种方式进行配置)
//  *      # 静态资源配置、配置完成后可直接在浏览器访问
//  *      # 默认值为 /** | 例如：若spring.mvc.static-path-pattern=/demo/** 那么访问时：http(s)://domain/xblog/demo/plugins/...
//  *      spring.mvc.static-path-pattern=/**
//  *      # 默认值为 classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/
//  *      spring.resources.static-locations=classpath:/static/
//  * 所以此处也可以不用配置，由于在application.properties中已配置，在这里配置之后两种方式都可以访问：
//  *      https://domain/xblog/plugins/...
//  *      https://domain/xblog/static/plugins/...
//  * 所以两处(此处和application.properties)的配置都生效
//  * </p>
//  *
//  * @author zwp
//  * @date 2018/12/13 16:20
//  */
// @Configuration
// public class StaticConfiguration implements WebMvcConfigurer {
//
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         // 为了统一配置，采用和application.properties中的配置一致
//         // registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
//         registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
//     }
// }
