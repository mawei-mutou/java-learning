package date20200112;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 21:53
 * description :
 */
public class IoTest7 {
    public static void main(String[] args) {
        //创建源
        File file = new File("C:\\Users\\MrYou\\Desktop\\119.txt");
        //选择流
        FileReader reader = null;

        {
            try {
                reader = new FileReader(file);
                //3、分段读取
                char[] flush = new char[1024];
                int len =-1;
                while ((len = reader.read(flush)) != -1) {
                    //字节数组到字符串
                    String str = new String(flush, 0, len);
                    System.out.println(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (null != reader) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
