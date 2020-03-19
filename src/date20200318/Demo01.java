package date20200318;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/18
 * time        : 13:15
 * description :测试和数据库建立连接
 */
public class Demo01 {
    public static void main(String[] args) {
        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            //建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接，比较耗时，这是Connection对象管理的一个要点！）
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象！
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/huxiaoyang",
                    "yaodong", "690725");
            long end = System.currentTimeMillis();
            System.out.println("建立连接的时间:"+(end-start)+"ms毫秒");

            Statement stmt=conn.createStatement();
            String name = "赵六";
            String sql = "insert into student values (2,'姚东',56)";
            stmt.execute(sql);

            //使用Statement 容易发生SQL注入
            String id = "5 or 1=1";
            String sql1="delete from student where id ="+id;
            stmt.execute(sql1);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
