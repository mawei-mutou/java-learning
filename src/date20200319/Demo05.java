package date20200319;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 12:46
 * description :选择某个时间段中的数据
 */
public class Demo05 {
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
            PreparedStatement ps=con.prepareStatement("select * from student where lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
            Timestamp start = new Timestamp(str2Date("2020-3-12 10:25:25"));
            Timestamp end = new Timestamp(str2Date("2020-3-13 15:30:40"));
            ps.setTimestamp(1,start);
            ps.setTimestamp(2,end);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "--->" + rs.getString("name")
                        + "--->" + rs.getTimestamp("lastLoginTime"));
            }
            con.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
