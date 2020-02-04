package date20200203;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 20:22
 * description :字节数组输入输出流
 */
public class IOTest11 {
    public static void main(String[] args) {
        byte[] data = null;
        byte[] src = "hello java.".getBytes();
        InputStream is = null;
        ByteArrayOutputStream os = null;
        is = new ByteArrayInputStream(src);
        os = new ByteArrayOutputStream();
        byte[] flush = new byte[1024];
        int len = -1;
        try {
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
                System.out.println("________________________");
            }
            os.write(flush, 0, flush.length);
            os.flush();
            data = os.toByteArray();
            System.out.println(new String(data,0,data.length));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
