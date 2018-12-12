package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Metas</p>
 * <p>Description: 项目表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:05
 */
public class Metas implements Serializable {
    //项目主键
    private Long mid;
    //名称
    private String name;
    //项目缩略名
    private String slug;
    //项目类型
    private String type;
    //项目描述
    private String description;
    //项目所属内容个数
    private Long count;
    //项目排序
    private Long order;
    
    private Long parent;


    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

}