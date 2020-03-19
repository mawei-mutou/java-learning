package date20200319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 10:38
 * description :
 */
public class Demo {
    public static void main(String[] args) {
        Connection con=null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");

            st = con.createStatement();
            String sql1 = "delete from student";
            st.execute(sql1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
