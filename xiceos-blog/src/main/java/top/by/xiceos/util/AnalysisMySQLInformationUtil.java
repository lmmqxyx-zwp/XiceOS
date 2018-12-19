package top.by.xiceos.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: AnalysisMySQLInformationUtil</p>
 * <p>Description: 解析MySQL数据库信息工具(需要扩展)</p>
 *
 * @author zwp
 * @date 2018/12/12 10:27
 */
public class AnalysisMySQLInformationUtil {

    public final static String URL      = "jdbc:mysql://192.168.0.249:3306/xiceos-blog";
    public final static String USERNAME = "oppox905";
    public final static String PASSWORD = "oppox905";

    /* 基础类包名支持 */
    public final static String VO_PACKAGE = "top.by.xiceos.vo";
    public final static String DAO_PACKAGE = "top.by.xiceos.dao";
    /* 是否开启驼峰标识、开启：true => 表字段为下划线分割转JAVA字段使用驼峰；关闭：false => 表字段对应JAVA字段 */
    public final static boolean IS_HUMP = false;
    /* mapper xml 文件生成位置 */
    public final static String CREATE_MAPPER_XML_PATH = "E:/tmp/mapper";
    /* 表前缀 */
    public final static String TABLE_PREFIX = "blog_";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    private Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     */
    private void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 根据数据表数据生成mybatis的mapper.xml映射文件
    public static void main(String[] args) {
        try {
            // System.out.println(new AnalysisMySQLInformationUtil().mapperXMLTemplate());
            AnalysisMySQLInformationUtil util = new AnalysisMySQLInformationUtil();
            List<String> tableNames = util.getTableNames(TABLE_PREFIX);
            System.out.println("表信息：\n===");
            for (String tableName: tableNames
                 ) {
                Map relationship = util.getTableColumn(tableName);
                System.out.println("表名：" + relationship.get("TABLE_NAME"));
                System.out.println("主键：" + relationship.get("PRIMARY_KEY"));
                System.out.println("列名：" + relationship.get("TABLE_COLUMN"));
                System.out.println("----------------------------------------------");
                util.createMapperXML(util.mapperXMLTemplate(), relationship, TABLE_PREFIX);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * mybatis mapper xml 模板
     *
     * @return
     */
    private String mapperXMLTemplate() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        sb.append("<mapper namespace=\"#{{NAMESPACE}}#\">\n");
        sb.append("    <sql id=\"table_name\">\n");
        // 设置表名称
        sb.append("        #{{TABLE_NAME}}#\n");
        sb.append("    </sql>\n");

        sb.append("\n");

        sb.append("    <sql id=\"table_column\">\n");
        // 设置表列
        sb.append("        #{{TABLE_COLUMN}}#\n");
        sb.append("    </sql>\n");

        sb.append("\n");

        sb.append("    <!-- 数据插入 -->\n");
        // 设置参数类型(实体全报名路径)
        sb.append("    <insert id=\"insert\" parameterType=\"#{{PARAMETERTYPE}}#\">\n");
        sb.append("        INSERT INTO\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");
        // 设置字段键(循环)
        sb.append("            <if test=\"#{{FIELD}}# != null\">\n");
        sb.append("                #{{FIELD}}#,\n");
        sb.append("            </if>\n");
        sb.append("        </trim>\n");
        sb.append("        <trim prefix=\"VALUES(\" suffix=\")\" suffixOverrides=\",\">\n");
        // 设置字段值(循环)
        sb.append("            <if test=\"#{{FIELD}}# != null\">\n");
        sb.append("                #{#{{FIELD}}#},\n");
        sb.append("            </if>\n");
        sb.append("        </trim>\n");
        sb.append("    </insert>\n");

        sb.append("\n");

        sb.append("    <!-- 数据删除 -->\n");
        sb.append("    <delete id=\"delete\" parameterType=\"java.lang.Long\">\n");
        sb.append("        DELETE FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        WHERE\n");
        // 设置主键
        sb.append("            #{{PRIMARYKEY}}# = #{#{{PRIMARYKEY}}#}\n");
        sb.append("    </delete>\n");

        sb.append("\n");

        sb.append("    <!-- 数据修改 -->\n");
        // 设置参数类型
        sb.append("    <update id=\"update\" parameterType=\"#{{PARAMETERTYPE}}#\">\n");
        sb.append("        UPDATE\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        <trim prefix=\"set\" suffixOverrides=\",\">\n");
        // 设置字段(循环)
        sb.append("            <if test=\"#{{FIELD}}# != null\">\n");
        sb.append("                #{{FIELD}}# = #{#{{FIELD}}#},\n");
        sb.append("            </if>\n");
        sb.append("        </trim>\n");
        sb.append("        WHERE\n");
        // 设置主键
        sb.append("            #{{PRIMARYKEY}}# = #{#{{PRIMARYKEY}}#}\n");
        sb.append("    </update>\n");

        sb.append("\n");

        sb.append("    <!-- 数据查询 单条数据 -->\n");
        // 设置返回数据类型
        sb.append("    <select id=\"findById\" parameterType=\"java.lang.Long\" resultType=\"#{{RESULTTYPE}}#\">\n");
        sb.append("        SELECT\n");
        sb.append("            <include refid=\"table_column\"/>\n");
        sb.append("        FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        WHERE\n");
        // 设置主键
        sb.append("            #{{PRIMARYKEY}}# = #{#{{PRIMARYKEY}}#}\n");
        sb.append("    </select>\n");

        sb.append("\n");

        sb.append("    <!-- 数据查询 多条数据 -->\n");
        // 设置返回数据类型
        sb.append("    <select id=\"findByIds\" resultType=\"#{{RESULTTYPE}}#\">\n");
        sb.append("        SELECT\n");
        sb.append("            <include refid=\"table_column\"/>\n");
        sb.append("        FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        WHERE\n");
        // 设置主键
        sb.append("            #{{PRIMARYKEY}}# IN\n");
        sb.append("        <foreach collection=\"array\" open=\"(\" separator=\",\" close=\")\" item=\"id\">\n");
        sb.append("            #{id}\n");
        sb.append("        </foreach>\n");
        sb.append("    </select>\n");

        sb.append("\n");

        sb.append("    <!-- 查询数据 全部 -->\n");
        // 设置返回数据类型
        sb.append("    <select id=\"findAll\" resultType=\"#{{RESULTTYPE}}#\">\n");
        sb.append("        SELECT\n");
        sb.append("            <include refid=\"table_column\"/>\n");
        sb.append("        FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("    </select>\n");

        sb.append("\n");

        sb.append("</mapper>\n");

        return sb.toString();
    }

    /**
     * 获取带前缀的表的名称的集合
     *
     * @param prefix 表名前缀
     * @return
     * @throws Exception
     */
    private List<String> getTableNames(String prefix) throws Exception {
        List<String> tableNames = null;
        Connection connection = this.getConnection();
        if (connection == null) {
            throw new AnalysisMySQLException("数据库连接获取为NULL、终止操作");
        }

        DatabaseMetaData dbMetData  = connection.getMetaData();

        ResultSet resultSet = dbMetData.getTables(null, USERNAME, null, new String[] {"table", "view"});

        tableNames = new ArrayList<>();

        while (resultSet.next()) {
            if (resultSet.getString(4) != null
                    && (resultSet.getString(4).equalsIgnoreCase("table"))
                    || resultSet.getString(4).equalsIgnoreCase("view")) {

                String tableName = resultSet.getString(3).toLowerCase();

                if (tableName.indexOf(prefix) != -1) {
                    tableNames.add(tableName);
                }
            }
        }

        this.closeConnection(connection);

        return tableNames;
    }

    /**
     * 获取表信息
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    private Map<String, String> getTableColumn(String tableName) throws Exception {
        Map<String, String> relationship = new HashMap<>();
        relationship.put("TABLE_NAME", tableName);

        Connection connection = this.getConnection();

        DatabaseMetaData dbMetData  = connection.getMetaData();

        ResultSet primaryKeys = dbMetData.getPrimaryKeys(null, null, tableName);

        String primaryKey = "";
        while (primaryKeys.next()) {
            primaryKey += primaryKeys.getString("COLUMN_NAME") + ", ";
        }

        if (primaryKey.length() != 0) {
            primaryKey = primaryKey.substring(0, primaryKey.length() - 2);
        }

        relationship.put("PRIMARY_KEY", primaryKey);

        String sql = "select * from " + tableName;

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();

        String columns = "";
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            String columnName = "`" + metaData.getColumnName(i + 1) + "`";
            // 类型
            // int type = metaData.getColumnType(i + 1);
            // if (Types.INTEGER == type) {
            //
            // }

            columns += columnName + ", ";
        }

        if (columns.length() != 0) {
            columns = columns.substring(0, columns.length() - 2);
        }
        relationship.put("TABLE_COLUMN", columns);

        this.closeConnection(connection);

        return relationship;
    }

    /**
     * 生成mapper文件
     *
     * @param mapperXMLTemplate mapper xml 模板
     * @param relationship      表关系
     */
    private void createMapperXML(String mapperXMLTemplate, Map<String, String> relationship, String prefix) {
        String tableName = relationship.get("TABLE_NAME");
        String primaryKey = relationship.get("PRIMARY_KEY");
        String columns = relationship.get("TABLE_COLUMN");

        String Dao           = DAO_PACKAGE + "." + tableName.substring(prefix.length(), prefix.length() + 1).toUpperCase() + tableName.substring(prefix.length() + 1, tableName.length()) + "Dao";
        String vo            = VO_PACKAGE + "." + tableName.substring(prefix.length(), prefix.length() + 1).toUpperCase() + tableName.substring(prefix.length() + 1, tableName.length());
        String mapperXmlName = tableName.substring(prefix.length(), prefix.length() + 1).toUpperCase() + tableName.substring(prefix.length() + 1, tableName.length()) + "Mapper.xml";

        // 废弃模板
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        sb.append("<mapper namespace=\"" + Dao + "\">\n");
        sb.append("    <sql id=\"table_name\">\n");
        sb.append("        " + tableName + "\n");
        sb.append("    </sql>\n");
        sb.append("\n");
        sb.append("    <sql id=\"table_column\">\n");
        sb.append("        " + columns + "\n");
        sb.append("    </sql>\n");
        sb.append("\n");
        sb.append("    <!-- 数据插入 -->\n");
        sb.append("    <insert id=\"insert\" parameterType=\"" + vo + "\">\n");
        sb.append("        INSERT INTO\n");
        sb.append("        <include refid=\"table_name\"/>\n");
        sb.append("        <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");
        String[] a = columns.split(", ");
        for (int i = 0; i < a.length; i++) {
            String b = a[i].substring(1, a[i].length() - 1);
            sb.append("            <if test=\"" + b + " != null\">\n");
            sb.append("                " + a[i] + ",\n");
            sb.append("            </if>\n");
        }
        sb.append("        </trim>\n");
        sb.append("        <trim prefix=\"VALUES(\" suffix=\")\" suffixOverrides=\",\">\n");
        for (int i = 0; i < a.length; i++) {
            String b = a[i].substring(1, a[i].length() - 1);
            sb.append("            <if test=\"" + b + " != null\">\n");
            sb.append("                #{" + b + "},\n");
            sb.append("            </if>\n");
        }
        sb.append("        </trim>\n");
        sb.append("    </insert>\n");
        sb.append("\n");
        sb.append("    <!-- 数据删除 -->\n");
        sb.append("    <delete id=\"delete\" parameterType=\"java.lang.Long\">\n");
        sb.append("        DELETE FROM\n");
        sb.append("        <include refid=\"table_name\"/>\n");
        sb.append("        WHERE\n");
        String[] b = primaryKey.split(", ");
        sb.append("        " + b[0] + " = #{" + b[0] + "}\n");
        sb.append("    </delete>\n");
        sb.append("\n");
        sb.append("    <!-- 数据修改 -->\n");
        sb.append("    <update id=\"update\" parameterType=\"" + vo + "\">\n");
        sb.append("        UPDATE");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        <trim prefix=\"set\" suffixOverrides=\",\">\n");
        for (int i = 0; i < a.length; i++) {
            String c = a[i].substring(1, a[i].length() - 1);
            sb.append("              <if test=\"" + c + " != null\">\n");
            sb.append("                " + a[i] + " = #{" + c + "},\n");
            sb.append("              </if>\n");
        }
        sb.append("        </trim>\n");
        sb.append("        WHERE\n");
        String[] c = primaryKey.split(", ");
        sb.append("            " + c[0] + " = #{" + c[0] + "}\n");
        sb.append("    </update>\n");
        sb.append("\n");
        sb.append("    <!-- 数据查询 单条数据 -->\n");
        sb.append("    <select id=\"findById\" parameterType=\"java.lang.Long\" resultType=\"" + vo + "\">\n");
        sb.append("        SELECT\n");
        sb.append("            <include refid=\"table_column\"/>\n");
        sb.append("        FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        WHERE\n");
        sb.append("            " + c[0] + " = #{" + c[0] + "}\n");
        sb.append("    </select>\n");
        sb.append("\n");
        sb.append("    <!-- 数据查询 多条数据 -->\n");
        sb.append("    <select id=\"findByIds\" resultType=\"" + vo + "\">\n");
        sb.append("        SELECT\n");
        sb.append("            <include refid=\"table_column\"/>\n");
        sb.append("        FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("        WHERE\n");
        sb.append("        " + c[0] + " IN\n");
        sb.append("        <foreach collection=\"array\" open=\"(\" separator=\",\" close=\")\" item=\"id\">\n");
        sb.append("            #{id}\n");
        sb.append("        </foreach>\n");
        sb.append("    </select>\n");
        sb.append("\n");
        sb.append("    <!-- 查询数据 全部 -->\n");
        sb.append("    <select id=\"findAll\" resultType=\"" + vo + "\">\n");
        sb.append("        SELECT\n");
        sb.append("            <include refid=\"table_column\"/>\n");
        sb.append("        FROM\n");
        sb.append("            <include refid=\"table_name\"/>\n");
        sb.append("    </select>\n");
        sb.append("\n");
        sb.append("</mapper>");

        // System.out.println(sb.toString());

        this.createFile(CREATE_MAPPER_XML_PATH, mapperXmlName, sb);
    }

    /**
     * 写入文件
     *
     * @param basePath 基本路径
     * @param fileName 文件名称
     * @param context  文件内容
     */
    private void createFile(String basePath, String fileName, StringBuilder context) {
        System.out.println("写入文件处理(" + basePath + File.separator + fileName + ") ... ");

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(basePath + File.separator + fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(context.toString());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class AnalysisMySQLException extends Exception {
        public AnalysisMySQLException(String message) {
            super(message);
        }
    }
}
