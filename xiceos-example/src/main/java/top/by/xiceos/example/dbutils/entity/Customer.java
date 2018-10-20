package top.by.xiceos.example.dbutils.entity;

import java.io.Serializable;

/**
 * <p>Title: Customer</p>
 * <p>Description: 客户类实体</p>
 *
 * @author zwp
 * @date 2018/10/20 10:34
 */
public class Customer implements Serializable {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "id          => " + id           + "\n"
             + "name        => " + name         + "\n"
             + "contact     => " + contact      + "\n"
             + "telephone   => " + telephone    + "\n"
             + "email       => " + email        + "\n"
             + "remark      => " + remark       + "\n";
    }
}
