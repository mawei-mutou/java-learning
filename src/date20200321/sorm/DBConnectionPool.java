package date20200321.sorm;

import date20200321.sorm.core.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/25
 * time        : 17:27
 * description :连接池
 */
public class DBConnectionPool {

    //连接池对象
    private static List<Connection> pool;
    //最大连接数
    private static final int POOL_MAX_SIZE = DBManager.getConf().getPOOL_MAX_SIZE();
    //最小连接数
    private static final int POOL_MIN_SIZE = DBManager.getConf().getPOOL_MIN_SIZE();

    /**
     * 初始化连接池，使池中连接数达到最大值
     */
    public void iniPool() {
        if (pool == null) {
            pool = new ArrayList<Connection>();
        }

        while (pool.size() < POOL_MIN_SIZE) {
            pool.add(DBManager.createConn());
            System.out.println("初始化池，池中连接数：" + pool.size());
        }
    }

    //从池中去连接
    public synchronized Connection getConection() {
        int last_index = pool.size() - 1;
        Connection c = pool.get(last_index);
        pool.remove(last_index);
        return c;
    }

    //将连接放回连接池中
    public synchronized void close(Connection connection) {
        if (pool.size() >= POOL_MAX_SIZE) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            pool.add(connection);
        }
    }


    public DBConnectionPool() {
        iniPool();
    }
}
