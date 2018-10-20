package top.by.xiceos.example.dbutils.helper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import top.by.xiceos.example.dbutils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: DatabaseHelper</p>
 * <p>Description: 数据库操作助手类</p>
 *
 * @author zwp
 * @date 2018/10/20 11:19
 */
public class DatabaseHelper {

    /* 表前缀 */
    private static final String TABLE_PREFIX = "t_";

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    /* 静态块加载数据库驱动 */
    static {
        try {
            Class.forName(Config.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    private DatabaseHelper() {

    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = CONNECTION_HOLDER.get();

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                CONNECTION_HOLDER.set(connection);
            }
        }

        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CONNECTION_HOLDER.remove();
        }
    }

    /**
     * 查询一个实体的集合
     *
     * @param entityClass   实体类型
     * @param sql           查询语句
     * @param params        查询参数
     * @param <T>           泛型
     * @return 实体集合
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object ... params) {
        List<T> entityList = null;

        try {
            Connection connection = getConnection();
            entityList = QUERY_RUNNER.query(connection, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return entityList;
    }

    /**
     * 查询一个实体
     *
     * @param entityClass   实体类型
     * @param sql           查询语句
     * @param params        查询参数
     * @param <T>           泛型
     * @return 实体
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object ... params) {
        T entity = null;

        try {
            Connection connection = getConnection();
            entity = QUERY_RUNNER.query(connection, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return entity;
    }

    /**
     * 查询语句执行
     *
     * @param sql    查询语句
     * @param params 查询参数
     * @return 返回的List中的Map中的数据为列名对应的值的映射
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object ... params) {
        List<Map<String, Object>> result = null;

        try {
            Connection connection = getConnection();
            result = QUERY_RUNNER.query(connection, sql, new MapListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    /**
     * 更新语句执行(insert update delete)
     *
     * @param sql    更新语句
     * @param params 参数
     * @return 返回数据改变的条数
     */
    public static int executeUpdate(String sql, Object ... params) {
        int rows = 0;

        try {
            Connection connection = getConnection();
            rows = QUERY_RUNNER.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return rows;
    }

    /**
     * 获取表名
     *
     * @param prefix        表前缀
     * @param entityClass   实体类类型
     * @return
     */
    private static String getTableName(String prefix, Class<?> entityClass) {
        String tableName = entityClass.getSimpleName().toLowerCase();

        if (prefix != null && !prefix.trim().equals("")) {
            return prefix + tableName;
        }

        return tableName;
    }

    /**
     * 插入一个实体
     *
     * @param entityClass 实体类型
     * @param fieldMap    实体字段映射
     * @param <T>
     * @return
     */
    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap) {
        if (!(fieldMap != null && fieldMap.size() != 0)) {
            return false;
        }

        String sql = "insert into " + getTableName(TABLE_PREFIX, entityClass);

        StringBuilder colums = new StringBuilder("(");
        StringBuilder valus  = new StringBuilder("(");

        for (String filedName: fieldMap.keySet()) {
            colums.append(filedName).append(", ");
            valus.append("?, ");
        }

        colums.replace(colums.lastIndexOf(", "), colums.length(), ")");
        valus.replace(valus.lastIndexOf(", "), valus.length(), ")");

        sql += colums + " values " + valus;

        Object[] params = fieldMap.values().toArray();

        return executeUpdate(sql, params) == 1;
    }

    /**
     * 更新一个实体
     *
     * @param entityClass 实体类型
     * @param id          主键
     * @param fieldMap    实体字段映射
     * @param <T>
     * @return
     */
    public static <T> boolean updateEntity(Class<T> entityClass, Object id, Map<String, Object> fieldMap) {
        if (!(fieldMap != null && fieldMap.size() != 0)) {
            return false;
        }

        String sql = "update " + getTableName(TABLE_PREFIX, entityClass) + " set ";

        StringBuilder colums = new StringBuilder("(");

        for (String filedName: fieldMap.keySet()) {
            colums.append(filedName).append("=?, ");
        }

        sql += colums.substring(0, colums.lastIndexOf(", ")) + " where id = ?";

        List<Object> list = new ArrayList<Object>();

        list.addAll(fieldMap.values());
        list.add(id);

        Object[] params = list.toArray();

        return executeUpdate(sql, params) == 1;
    }

    /**
     * 删除一个实体
     *
     * @param entityClass 实体类型
     * @param id          主键
     * @param <T>
     * @return
     */
    public static <T> boolean deleteEntity(Class<T> entityClass, Object id) {
        String sql = "delete from " + getTableName(TABLE_PREFIX, entityClass) + " where id = ?";

        return executeUpdate(sql, id) == 1;
    }


}
