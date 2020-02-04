package date20200203;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 17:54
 * description :字节数组输出流
 */
public class IOTest08 {
    public static void main(String[] args) {
        //1、不需要创建源，系统内部维护
        byte[] dest = null;
        //2、选择流，由于有新方法toByteArray(),所以不用OutputStream
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            String str = "talk is cheap show me the code";
            byte[] datas = str.getBytes();
            baos.write(datas, 0, datas.length);//从程序中写出来
            baos.flush();

            dest = baos.toByteArray();
            System.out.println(new String(dest,0,dest.length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
