package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 15:05
 * description :
 */
public class IOTest03 {
    public static void main(String[] args) {
        File src = new File("IOLearning.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(src);
            String str = "Java is so easy!";
            byte[] datas = str.getBytes();
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
