package date20200319;

import java.sql.*;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 10:59
 * description :
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
            String sql = "select * from student where id<?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,5);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getDate(1)+"--->"+rs.getObject(2)+"---->"+rs.getObject(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
