package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 13:58
 * description :
 */
public class IOTest01 {
    public static void main(String[] args) {
        File src = new File("IO.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);

            int temp = 0;
            while ((temp = is.read()) != -1) {
                System.out.print((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
