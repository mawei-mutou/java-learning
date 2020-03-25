package date20200321.sorm.core;

import date20200321.sorm.DBConnectionPool;
import date20200321.sorm.bean.Configuration;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 19:05
 * description :根据配置信息，维持连接对象的管理（增加连接池的功能）
 */
public class DBManager {

    private static Configuration conf = null;

    private static DBConnectionPool pool;

    static{//静态代码块,去读取db.Properties里面的数据
        BufferedInputStream bf = null;
        Properties pros = new Properties();
        try {
            bf = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\MrYou\\Desktop\\java-learning\\src\\date20200321\\sorm\\db.properties")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pros.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf = new Configuration();
        conf.setMysqlDriver(pros.getProperty("mysqlDriver"));
        conf.setPoPackage(pros.getProperty("poPackage"));
        conf.setMysqlPwd(pros.getProperty("mysqlPwd"));
        conf.setJdbUrl(pros.getProperty("jdbUrl"));
        conf.setMysqlUser(pros.getProperty("mysqlUser"));
        conf.setSrcPath(pros.getProperty("srcPath"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        conf.setQueryClass(pros.getProperty("queryClass"));
        conf.setPOOL_MAX_SIZE((Integer.parseInt(pros.getProperty("POOL_MAX_SIZE"))));
        conf.setPOOL_MIN_SIZE((Integer.parseInt(pros.getProperty("POOL_MIN_SIZE"))));

        System.out.println(TableContext.class);

    }


    public static Connection createConn() {
        try {
            Class.forName(conf.getMysqlDriver());

            return DriverManager.getConnection(conf.getJdbUrl(),conf.getMysqlUser(),conf.getMysqlPwd());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Connection getConn() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool.getConection();
    }
    public static void close(ResultSet rs, Statement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (conn != null) {
            pool.close(conn);

        }
    }
    public static void close( Statement ps, Connection conn) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (conn != null) {
            pool.close(conn);

        }
    }
    public static void close(Connection conn) {
        if (conn != null) {
            pool.close(conn);

        }
    }
    public static Configuration getConf() {
        return conf;
    }

}
