package date20200112;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 20:14
 * description :
 */
public class IoTest2 {
    public static void main(String[] args) {
        //创建源
        File src = new File("C:\\Users\\MrYou\\Desktop\\abc.txt");
        //选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //读取
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.print((char)temp);
            }


               } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

