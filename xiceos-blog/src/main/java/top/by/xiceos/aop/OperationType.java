package top.by.xiceos.aop;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: OperationType</p>
 * <p>Description: 日志相关枚举</p>
 *
 * @author zwp
 * @date 2018/12/26 11:27
 */
public enum OperationType {

    INSERT("增加"),

    DELETE("删除"),

    UPDATE("修改"),

    SELECT("查询"),

    UPLOAD("上传"),

    DOWNLOAD("下载"),

    LOGIN("登入"),

    LOGOUT("登出");

    private OperationType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<OperationType> getOperationTypes() {
        return Arrays.asList(OperationType.values());
    }

}
