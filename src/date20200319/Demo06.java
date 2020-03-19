package date20200319;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 12:46
 * description :测试文本大对象的插入和取出。
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
            con.setAutoCommit(false);

            //PreparedStatement ps=con.prepareStatement("alter table student add info text not null ");
            //向数据库里面插入一个文本文件
            PreparedStatement ps=con.prepareStatement("insert into student (id,age,regTime,lastLoginTime,info) values (?,15,'2020-03-19',now(),?)");
            ps.setInt(1,101);
           // ps.setClob(2,new FileReader(new File("C:\\Users\\MrYou\\Desktop\\a.txt")));
            ps.setClob(2, new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream("加油，加油，坚持到底".getBytes()))));
            ps.execute();


            //从数据库取出Clob数据
            ps = con.prepareStatement("select * from student where id =100");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clob c = rs.getClob("info");
                Reader r = c.getCharacterStream();
                int temp =0;
                while ((temp = r.read()) != -1) {
                    System.out.print((char)temp);
                }
            }
            con.commit();

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
