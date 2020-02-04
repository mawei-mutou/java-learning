package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 16:10
 * description :文件字符输入流
 */
public class IOTest05 {
    public static void main(String[] args) {
        File src = new File("IO.txt");
        Reader reader = null;
        try {
            reader = new FileReader(src);
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                System.out.println(flush);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
