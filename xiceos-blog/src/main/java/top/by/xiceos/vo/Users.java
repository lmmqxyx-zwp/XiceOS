package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Users</p>
 * <p>Description: 用户表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:05
 */
public class Users implements Serializable {
    //主键
    private Long uid;
    //用户名称
    private String username;
    //用户密码
    private String password;
    //用户邮箱
    private String mail;
    //用户主页
    private String url;
    //用户显示的名称
    private String screenname;
    //用户注册时时间戳
    private Long created;
    //最后活动时间
    private Long activated;
    //上次登录最后活跃时间
    private Long logged;
    //用户组
    private String group;
    //用户登录验证码
    private String authcode;
    //记住登录状态
    private Integer remember;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getActivated() {
        return activated;
    }

    public void setActivated(Long activated) {
        this.activated = activated;
    }

    public Long getLogged() {
        return logged;
    }

    public void setLogged(Long logged) {
        this.logged = logged;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public Integer getRemember() {
        return remember;
    }

    public void setRemember(Integer remember) {
        this.remember = remember;
    }
}