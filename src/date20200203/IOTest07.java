package date20200203;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 17:21
 * description :字节数组输出流
 */
public class IOTest07 {
    public static void main(String[] args) {
        //1、创建源头
        byte[] src = "talk is cheap show me the code".getBytes();
        //2、选择流
        InputStream is = null;
        is = new ByteArrayInputStream(src);
        byte[] flush = new byte[10];
        int len = -1;
        try {
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
