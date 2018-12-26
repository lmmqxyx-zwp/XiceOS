package top.by.xiceos.vo;

import java.io.Serializable;
import java.util.Map;

// Alternative format of the node (id & parent are required)
//     {
//             id          : "string" // required
//             parent      : "string" // required
//             text        : "string" // node text
//             icon        : "string" // string for custom
//             state       : {
//             opened    : boolean  // is the node open
//             disabled  : boolean  // is the node disabled
//             selected  : boolean  // is the node selected
//             },
//             li_attr     : {}  // attributes for the generated LI node
//             a_attr      : {}  // attributes for the generated A node
//     }
/**
 * <p>Title: JsTree</p>
 * <p>Description:
 *      预定使用JsTree来操作树形结构，封装该类
 *      使用：只需要一次性全部查询表中数据即可
 * </p>
 *
 * @author zwp
 * @date 2018/12/24 17:35
 */
public class JsTree<T> implements Serializable {

    private String id;
    private String parent;
    private String text;
    private String icon;
    private Map<String, Boolean> state;
    // TODO 注意：不使用此种方式进行封装
    // Expected format of the node (there are no required fields)
    // {
    //     id          : "string" // will be autogenerated if omitted
    //     text        : "string" // node text
    //     icon        : "string" // string for custom
    //     state       : {
    //         opened    : boolean  // is the node open
    //         disabled  : boolean  // is the node disabled
    //         selected  : boolean  // is the node selected
    //     },
    //     children    : []  // array of strings or objects
    //     li_attr     : {}  // attributes for the generated LI node
    //     a_attr      : {}  // attributes for the generated A node
    // }
    // private List<JsTree> children;
    // 源数据
    private T data;
    private Map<String, Object> li_attr;
    private Map<String, Object> a_attr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, Boolean> getState() {
        return state;
    }

    public void setState(Map<String, Boolean> state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getLiattr() {
        return li_attr;
    }

    public void setLiattr(Map<String, Object> liAttr) {
        this.li_attr = liAttr;
    }

    public Map<String, Object> getAattr() {
        return a_attr;
    }

    public void setAattr(Map<String, Object> aAttr) {
        this.a_attr = aAttr;
    }
}