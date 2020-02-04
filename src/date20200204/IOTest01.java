package date20200204;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 13:24
 * description :文件字节输入流，增加字节缓冲流
 */
public class IOTest01 {
    public static void main(String[] args) {
        File src = new File("IO.txt");
        try(InputStream is = new BufferedInputStream(new FileInputStream(src)))
 {
            //is = new BufferedInputStream(new FileInputStream(src));
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
