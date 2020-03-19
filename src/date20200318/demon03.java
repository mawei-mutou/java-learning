package date20200318;

import java.sql.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/18
 * time        : 15:42
 * description :测试ResultSet结果集
 */
public class demon03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");

            String sql1 = "select id,name,age,regTime from student where id> ?";
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setObject(1, 100);

            ResultSet rs = ps.executeQuery();//executeQuery()传回一个ResultSet结果集。
            while (rs.next()) {
                System.out.println(rs.getObject(1) + "--->" + rs.getObject(2)
                        + "--->" + rs.getObject(3) + "===>" + rs.getObject(4));
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
