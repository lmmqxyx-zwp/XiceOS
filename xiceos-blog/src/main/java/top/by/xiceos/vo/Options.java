package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Options</p>
 * <p>Description: 配置表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:05
 */
public class Options implements Serializable {
    //配置名称
    private String name;
    //配置所属用户、默认位0(全局配置)
    private Long user;
    //配置值
    private String value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}