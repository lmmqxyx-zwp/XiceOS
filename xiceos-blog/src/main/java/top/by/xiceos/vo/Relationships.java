package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Relationships</p>
 * <p>Description: 关系表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:05
 */
public class Relationships implements Serializable {
    //blog_contents表主键
    private Long cid;
    //blog_metas表主键
    private Long mid;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

}