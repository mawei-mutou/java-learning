package date20200318;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/18
 * time        : 14:35
 * description 测试preparedConnection
 */
public class Demon02 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
//            String sql = "insert into student values (?,?,?)";//?为占位符
//            PreparedStatement ps=con.prepareStatement(sql);
//
//            //传具体的参数，第一个数字为索引，从1开始。
//            ps.setString(1, "8");
//            ps.setString(2, "胡晓阳");
//            ps.setString(3, "24");
//
//            ps.execute();

//            String sql1 = "alter table student add regTime date not null";
//            ps.execute(sql1);

            String sql2 = "insert into student values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql2);
            ps.setObject(1, 520);
            ps.setObject(2, "木头和马尾");
            ps.setObject(3, 51);
            ps.setObject(4, new java.sql.Date(System.currentTimeMillis()));

            ps.execute();



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
