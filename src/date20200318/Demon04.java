package date20200318;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/18
 * time        : 16:25
 * description :
 */
public class Demon04 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
            con.setAutoCommit(false);//设置手动提交
            long start = System.currentTimeMillis();
            Statement st = con.createStatement();
            for (int i = 0; i < 20000; i++) {
                st.addBatch("insert into student values (2,'姚胡',999,now())");
            }
            st.executeBatch();
            con.commit();//提交事务
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
