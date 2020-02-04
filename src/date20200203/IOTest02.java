package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 14:37
 * description :
 */
public class IOTest02 {
    public static void main(String[] args) {
        File src = new File("IO.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);

            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
