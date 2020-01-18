package date20200114;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**字节数组输入流
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/14
 * time        : 14:11
 * description :
 */
public class IoTest01 {
    public static void main(String[] args) {
        //1、创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        //2、选择流
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            //3、操作（分段读取）
            byte[] flush = new byte[20];//缓冲容器
            int len = -1;//接受长度
            while ((len = is.read(flush)) != -1) {
                //字节数组转变为字符串(解码)
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
