package top.by.xiceos.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: OperationLog</p>
 * <p>Description: 日志实体</p>
 *
 * @author zwp
 * @date 2018/12/26 14:24
 */
public class OperationLog implements Serializable {

    // 主键ID
    private Integer lid;
    // 用户主键
    private Integer uid;
    // 用户名称
    private String username;
    // 用户IP
    private String ip;
    // 操作参数
    private String param;
    // 操作描述
    private String desc;
    // 日志类型
    private String type;
    // 创建时间
    private Date createtime;
    // 日志结果
    private String result;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
