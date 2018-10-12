package top.by.xiceos.entity;

import java.io.Serializable;

/**
 * <p>Title: GeneratorParams</p>
 * <p>Description: 代码生成器参数表(开发者)</p>
 *
 * <p>
 *     mybatis-plus初始化模板注释等相关参数 <br />
 *     1、后台代码相关参数 <br />
 *     2、前台页面代码相关参数 <br />
 * </p>
 *
 * @author zwp
 * @date 2018/10/10 11:29
 */
public class GeneratorParams implements Serializable {
    /**
     * 数据库账号
     */
    private String userName;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 数据库url
     */
    private String url;

    /**
     * 项目根地址
     */
    private String projectPath;

    /**
     * 作者、用来作为类注释用
     */
    private String author;

    /**
     * 项目包名、转换出生成路径
     */
    private String packageName;

    /**
     * 数据表名称
     */
    private String tableName;

    /**
     * 数据库表前缀
     */
    private String tableNamePrefix;

    /**
     * 是否忽略的表前缀
     */
    private boolean ignoreTabelPrefix = true;

    /**
     * 是否生成controller开关
     */
    private Boolean controllerSwitch = false;

    /**
     * 是否生成dao开关
     */
    private Boolean daoSwitch = false;

    /**
     * 是否生成service开关
     */
    private Boolean serviceSwitch = false;

    /**
     * 是否生成entity开关
     */
    private Boolean entitySwitch = false;

    /**
     * 是否生成sql开关
     */
    private Boolean sqlSwitch = false;

    // =================================================================================================================
    // 以下为前端页面生成代码相关参数

    /**
     * 业务名称
     */
    private String bizName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 父级菜单名称
     */
    private String parentMenuName;

    /**
     * 主页
     */
    private Boolean indexPageSwitch = false;

    /**
     * 添加页面
     */
    private Boolean addPageSwitch = false;

    /**
     * 编辑页面
     */
    private Boolean editPageSwitch = false;

    /**
     * 主页的js
     */
    private Boolean jsSwitch = false;

    /**
     * 详情页面js
     */
    private Boolean infoJsSwitch = false;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNamePrefix() {
        return tableNamePrefix;
    }

    public void setTableNamePrefix(String tableNamePrefix) {
        this.tableNamePrefix = tableNamePrefix;
    }

    public boolean getIgnoreTabelPrefix() {
        return ignoreTabelPrefix;
    }

    public void setIgnoreTabelPrefix(boolean ignoreTabelPrefix) {
        this.ignoreTabelPrefix = ignoreTabelPrefix;
    }

    public Boolean getControllerSwitch() {
        return controllerSwitch;
    }

    public void setControllerSwitch(Boolean controllerSwitch) {
        this.controllerSwitch = controllerSwitch;
    }

    public Boolean getDaoSwitch() {
        return daoSwitch;
    }

    public void setDaoSwitch(Boolean daoSwitch) {
        this.daoSwitch = daoSwitch;
    }

    public Boolean getServiceSwitch() {
        return serviceSwitch;
    }

    public void setServiceSwitch(Boolean serviceSwitch) {
        this.serviceSwitch = serviceSwitch;
    }

    public Boolean getEntitySwitch() {
        return entitySwitch;
    }

    public void setEntitySwitch(Boolean entitySwitch) {
        this.entitySwitch = entitySwitch;
    }

    public Boolean getSqlSwitch() {
        return sqlSwitch;
    }

    public void setSqlSwitch(Boolean sqlSwitch) {
        this.sqlSwitch = sqlSwitch;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public Boolean getIndexPageSwitch() {
        return indexPageSwitch;
    }

    public void setIndexPageSwitch(Boolean indexPageSwitch) {
        this.indexPageSwitch = indexPageSwitch;
    }

    public Boolean getAddPageSwitch() {
        return addPageSwitch;
    }

    public void setAddPageSwitch(Boolean addPageSwitch) {
        this.addPageSwitch = addPageSwitch;
    }

    public Boolean getEditPageSwitch() {
        return editPageSwitch;
    }

    public void setEditPageSwitch(Boolean editPageSwitch) {
        this.editPageSwitch = editPageSwitch;
    }

    public Boolean getJsSwitch() {
        return jsSwitch;
    }

    public void setJsSwitch(Boolean jsSwitch) {
        this.jsSwitch = jsSwitch;
    }

    public Boolean getInfoJsSwitch() {
        return infoJsSwitch;
    }

    public void setInfoJsSwitch(Boolean infoJsSwitch) {
        this.infoJsSwitch = infoJsSwitch;
    }
}
