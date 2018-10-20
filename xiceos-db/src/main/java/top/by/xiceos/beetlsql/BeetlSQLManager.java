package top.by.xiceos.beetlsql;

import org.beetl.sql.core.SQLManager;
import top.by.xiceos.util.PropertiesUtil;

/**
 * <p>Title: BeetlSQLManager</p>
 * <p>Description: beetlsql操作类</p>
 *
 * @author zwp
 * @date 2018/10/12 22:07
 */
public class BeetlSQLManager {

    private static volatile BeetlSQLManager manager;

    private ThreadLocal<SQLManager> threadLocal = new ThreadLocal<SQLManager>();

    private BeetlSQLManager() {

    }

    /**
     * 获取一个单例类
     *
     * @return
     */
    public static BeetlSQLManager getInstance() {
        if (manager == null) {
            synchronized (BeetlSQLManager.class) {
                if (manager == null) {
                    manager = new BeetlSQLManager();
                }
            }
        }
        return manager;
    }

}
