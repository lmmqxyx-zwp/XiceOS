package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Contents</p>
 * <p>Description: 内容表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:04
 */
public class Contents implements Serializable {
    //主键
    private Long cid;
    //内容标题
    private String title;
    //内容缩略名
    private String slug;
    //内容生成时的时间戳
    private Long created;
    //内容更新时的时间戳
    private Long modified;
    //内容文字
    private String text;
    //排序
    private Long order;
    //内容所属用户ID
    private Long authorid;
    //内容使用的模板
    private String template;
    //内容类别
    private String type;
    //内容状态
    private String status;
    //受保护内容、对应内容保护密码
    private String password;
    //内容所属评论数、冗余字段
    private Long commentsnum;
    //是否允许评论
    private String allowcomment;
    //是否允许ping
    private String allowping;
    //允许出现再聚合中
    private String allowfeed;
    //父级内容ID
    private Long parent;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCommentsnum() {
        return commentsnum;
    }

    public void setCommentsnum(Long commentsnum) {
        this.commentsnum = commentsnum;
    }

    public String getAllowcomment() {
        return allowcomment;
    }

    public void setAllowcomment(String allowcomment) {
        this.allowcomment = allowcomment;
    }

    public String getAllowping() {
        return allowping;
    }

    public void setAllowping(String allowping) {
        this.allowping = allowping;
    }

    public String getAllowfeed() {
        return allowfeed;
    }

    public void setAllowfeed(String allowfeed) {
        this.allowfeed = allowfeed;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

}