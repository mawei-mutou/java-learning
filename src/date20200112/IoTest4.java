package date20200112;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 20:36
 * description :
 */
public class IoTest4 {
    public static void main(String[] args) {
        //创建源
        File file = new File("C:\\Users\\MrYou\\Desktop\\abc.txt");
        //选择流
        InputStream is = null;

        {
            try {
                is = new FileInputStream(file);
                //3、分段读取
                byte[] flush = new byte[5];
                int len =-1;
                while ((len = is.read(flush)) != -1) {
                    //字节数组到字符串
                    String str = new String(flush, 0, len);
                    System.out.println(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
