package date20200203;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 20:47
 * description :
 */
public class IOTest12 {
    public static void main(String[] args) {
        byte[] data = null;
        ByteArrayOutputStream bao = null;
        String str = "I love you!";
        byte[] flush = str.getBytes();
        bao = new ByteArrayOutputStream();
        bao.write(flush, 0, flush.length);
        try {
            bao.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
       data= bao.toByteArray();
        System.out.println(new String(data,0,bao.size()));
    }
}
