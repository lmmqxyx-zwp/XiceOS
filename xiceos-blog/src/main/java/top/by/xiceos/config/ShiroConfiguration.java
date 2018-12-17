package top.by.xiceos.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.by.xiceos.dao.ShiroRealm;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean instanceShiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // authc:所有url都必须认证通过才可以访问
        // anon: 所有url都可以匿名访问
        // 配置不会被拦截的路径、顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");

        // 排至推出过滤器
        filterChainDefinitionMap.put("/logout", "logout");

        // 若不设置默认会自动寻找web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 未授权的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroRealm instanceShiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();

        return shiroRealm;
    }

    @Bean
    public SecurityManager instanceSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(instanceShiroRealm());

        return securityManager;
    }

}
