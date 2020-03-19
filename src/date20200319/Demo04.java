package date20200319;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import static java.lang.Math.random;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 12:46
 * description :测试事务
 */
public class Demo04 {
    public static long str2Date(String dateStr) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long a= format.parse(dateStr).getTime();
        System.out.println(a);
        return a;
    }
    public static void main(String[] args) {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
            String str = "alter table student add lastLoginTime timestamp not null";
            Statement st=con.createStatement();
            st.execute(str);
            con.setAutoCommit(false);
            for (int i = 0; i < 100; i++) {
                PreparedStatement ps=con.prepareStatement("insert into student values (?,?,?,?,?)");
                ps.setObject(1, 5);
                ps.setObject(2, "乔丹");
                ps.setObject(3, 6);
                long t = 100000000 + new Random().nextInt(1000000000);
                Timestamp stamp = new Timestamp((System.currentTimeMillis()-t));
                Date date = new Date(System.currentTimeMillis());
                ps.setObject(4, date);
                ps.setTimestamp(5,stamp);
                ps.execute();
                con.commit();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
