package date20200112;

import java.io.UnsupportedEncodingException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 18:27
 * description :
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "我三栋三肯教";
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);
//        datas = msg.getBytes("UTF-16LE");
//        System.out.println(datas.length);

        //解码
        msg = new String(datas, 0, datas.length, "UTF8");
        System.out.println(msg);
    }
}