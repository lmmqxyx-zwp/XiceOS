package top.by.xiceos.form;

import java.io.Serializable;

/**
 * <p>Title: LoginUser</p>
 * <p>Description: 登录用户</p>
 *
 * @author zwp
 * @date 2018/12/14 16:55
 */
public class LoginUser implements Serializable {
    private String username;
    private String password;
    private Integer remember;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRemember() {
        return remember;
    }

    public void setRemember(Integer remember) {
        this.remember = remember;
    }
}
