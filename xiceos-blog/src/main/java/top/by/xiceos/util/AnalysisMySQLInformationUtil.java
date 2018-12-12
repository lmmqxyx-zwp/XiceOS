package top.by.xiceos.util;

/**
 * <p>Title: AnalysisMySQLInformationUtil</p>
 * <p>Description: 解析MySQL数据库信息工具</p>
 *
 * @author zwp
 * @date 2018/12/12 10:27
 */
public class AnalysisMySQLInformationUtil {

    public final static String URL      = "jdbc:mysql://192.168.0.244:3306/xiceos-blog";
    public final static String USERNAME = "oppox905";
    public final static String PASSWORD = "oppox905";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
