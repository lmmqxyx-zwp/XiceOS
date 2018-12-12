package top.by.xiceos.vo;

import java.io.Serializable;

/**
 * <p>Title: Fields</p>
 * <p>Description: 扩展字段表</p>
 *
 * @author zwp
 * @date 2018/12/12 12:04
 */
public class Fields implements Serializable {
    //联合主键
    private Long cid;
    //字段名称、联合主键
    private String name;
    //字段类型
    private String type;
    //字段对应字符串值
    private String strValue;
    //整型
    private Long intValue;
    //浮点型
    private Float floatValue;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public Long getIntValue() {
        return intValue;
    }

    public void setIntValue(Long intValue) {
        this.intValue = intValue;
    }

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }
}