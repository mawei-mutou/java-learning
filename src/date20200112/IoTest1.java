package date20200112;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 20:04
 * description :
 */
public class IoTest1 {
    public static void main(String[] args) {
        //创建源
        File src = new File("C:\\Users\\MrYou\\Desktop\\abc.txt");
        //选择流
        try {
            InputStream is = new FileInputStream(src);
            //读取
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();
            int data5 = is.read();
            int data6 = is.read();
            int data7 = is.read();
            int data8 = is.read();
            int data9 = is.read();
            int data10 = is.read();
            int data11 = is.read();

            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)data4);
            System.out.println((char)data5);
            System.out.println((char)data6);
            System.out.println((char)data7);
            System.out.println((char)data8);
            System.out.println((char)data9);
            System.out.println((char)data10);
            System.out.println(data11);//不是数据，文件末尾返回-1

            //释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
