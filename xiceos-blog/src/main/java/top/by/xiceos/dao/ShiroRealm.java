package top.by.xiceos.dao;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class ShiroRealm implements Realm {

    private static final String SHIRO_REALM_NAME = "MYSQL_REALM";

    @Override
    public String getName() {
        return SHIRO_REALM_NAME;
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获得用户名
        String username = (String) authenticationToken.getPrincipal();
        // 获得密码
        String password = new String((char[]) authenticationToken.getCredentials());

        if (!"username".equals(username)) {
            // 身份验证失败
            throw new UnknownAccountException();
        }

        if (!"password".equals(password)) {
            // 密码验证失败
            throw new IncorrectCredentialsException();
        }

        // 若验证成功，返回一个AuthenticationInfo实现
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}

// ==============================================================
//  Shiro
// ==============================================================
// |---Spring security，与Spring依赖过于紧密，没有Shiro使用简单
//             |---使用Shiro实现系统的权限管理，有效提高开发效率。
//             |
//             |---架构
//             |---subject：主体，可以是用户，也可以是程序，系统需要对主体进行认证、授权
//             |---Security Manager：安全管理器，主体进行认证和授权都是通过security manager进行
//             |---authenticator：认证器，主体进行认证最终通过authenticator进行的
//             |---Authorizer：授权器，主体进行授权最终同工过authorizer进行的
//             |---session manager：web应用中一般是用web容器对session进行管理。shiro也提供一套session管理机制。
//             |---sessionDao：通过这个来管理session数据。针对个性化的session数据的存储需要用到sessionDAO
//             |---cache manager：缓存管理器，主要对session和授权数据进行缓存。将授权数据通过cache manager进行缓存管理。
//             |---realms：领域，域，相当于数据源，通过realm存取认证、授权相关数据。
//             |---在realm中存储授权和认证的逻辑。
//             |---cryptography：即密码管理，提供了一套加密和解密的组件，方便开发。
//             |---MD5散列算法
