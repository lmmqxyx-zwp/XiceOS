package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Comments</p>
 * <p>Description: 评论表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:03
 */
public class Comments implements Serializable {

    //主键、非负数、自增
    private Long coid;
    //blog_contents表主键
    private Long cid;
    //评论生成时的时间戳
    private Long created;
    //评论作者
    private String author;
    //评论所属用户ID
    private Long authorid;
    //评论所属内容作者ID
    private Long ownerid;
    //评论者邮件
    private String mail;
    //评论者网址
    private String url;
    //评论者IP地址
    private String ip;
    //评论者客户端
    private String agent;
    //评论文字
    private String text;
    //评论类型
    private String type;
    //评论状态
    private String status;
    //父级评论
    private Long parent;


    public Long getCoid() {
        return coid;
    }

    public void setCoid(Long coid) {
        this.coid = coid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

}