package date20200114;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**字节数组输出流
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/14
 * time        : 15:07
 * description :
 */
public class IoTest02 {
    public static void main(String[] args) {
        //1、不用选择源，系统内部维护
        byte[] dest =null;
        //2、选择流（由于有新增的方法，所以不用父类的流OutputStream）
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            //3、操作（写出）
            String msg = "show me the code";

            byte[] datas = msg.getBytes();//字符串到字节数组（编码）
            baos.write(datas, 0, datas.length);//将字节数组的内容写入到字节数组流baos里面去了
            baos.flush();

            //获取数据
            dest = baos.toByteArray();//将 字节数组流转为字节数组
            System.out.println(dest.length + "-->" + new String(dest, 0, baos.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
