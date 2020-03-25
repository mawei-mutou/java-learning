package date20200319;

import java.io.*;
import java.sql.*;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/19
 * time        : 12:46
 * description :测试BLOB对象的插入和取出。
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con=JDBCUtils.getMySqlConn();
            System.out.println(con);
            con.setAutoCommit(false);

            //PreparedStatement ps=con.prepareStatement("alter table student add info text not null ");
            //向数据库里面插入一个图像文件
            ps=con.prepareStatement("insert into student (id,age,regTime,lastLoginTime,info,head) values (?,15,'2020-03-19',now(),?,?)");
            //PreparedStatement ps=con.prepareStatement("insert into student (info,head) values (?,?)");
            ps.setInt(1,101);
           // ps.setClob(2,new FileReader(new File("C:\\Users\\MrYou\\Desktop\\a.txt")));
            ps.setClob(2, new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream("图片信息".getBytes()))));
            ps.setBlob(3, new FileInputStream("C:\\Users\\MrYou\\Desktop\\1.png"));
            ps.execute();


            //从数据库取出Clob数据
            ps = con.prepareStatement("select * from student where id =101");
           rs = ps.executeQuery();
            while (rs.next()) {
                Blob  b = rs.getBlob("head");
                InputStream is = b.getBinaryStream();
                OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\MrYou\\Desktop\\copy2.png")));
                int temp =0;
                while ((temp = is.read()) != -1) {
                    out.write(temp);
                    out.flush();
                }
            }
            con.commit();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
