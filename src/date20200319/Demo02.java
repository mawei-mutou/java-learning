package date20200319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 11:08
 * description :
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");

            con.setAutoCommit(false);
            Statement st = con.createStatement();
            for (int i = 0; i < 10; i++) {
                int count =1;
                st.addBatch("insert into student values (4,'当地',4+1,now())");
            }
            st.executeBatch();
            con.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
