package date20200319;

import java.sql.*;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 12:46
 * description :测试事务
 */
public class Demo03 {
    public static void main(String[] args) {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("insert into student values (?,?,?,?)");
            ps.setObject(1, 5);
            ps.setObject(2, "乔丹");
            ps.setObject(3, 6);

            Date date = new Date(System.currentTimeMillis());
            ps.setObject(4, date);
            ps.execute();

            Thread.sleep(6000);

            PreparedStatement ps2=con.prepareStatement("insert into student values (?,?,?,?)");
            ps2.setObject(1, 5);
            ps2.setObject(2, "乔丹");
            ps2.setObject(3, 6);
            ps2.setObject(4, date);
            ps2.execute();
        } catch (ClassNotFoundException | SQLException | InterruptedException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
