package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 18:33
 * description :文件字节输入输出流
 */
public class IOTest09 {
    public static void main(String[] args) {
        File src1 = new File("C:\\Users\\MrYou\\Desktop\\java-learning\\src\\images\\bg.jpg");
        File src2 = new File("COPY3.txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src1);
            os = new FileOutputStream(src2);
            byte[] flush = new byte[1024];
            int len = -1;

            while ((len = is.read(flush)) != -1) {
//                String str = new String(flush, 0, flush.length);
//                System.out.println(str);
                os.write(flush, 0, flush.length);
                os.flush();
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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
