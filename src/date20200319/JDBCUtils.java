package date20200319;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/22
 * time        : 12:46
 * description :
 */
public class JDBCUtils {
    public static void main(String[] args) {
        System.out.println(pros);
        System.out.println(pros.getProperty("db.mysqlDriver"));
        System.out.println(pros.getProperty("db.jdbUrl"));
    }

    static Properties pros = new Properties();
    static{

        try {
            FileInputStream fi = new FileInputStream(new File("src/date20200319/db.properties"));
            pros.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Connection getMySqlConn() {

        try {
            Class.forName(pros.getProperty("db.mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("db.jdbUrl"), pros.getProperty("db.mysqlUser"), pros.getProperty("db.mysqlPwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
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
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn) {
       if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
