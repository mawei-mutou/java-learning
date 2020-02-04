package date20200202;

import java.io.UnsupportedEncodingException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/2
 * time        : 15:34
 * description :
 */
public class TestContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "我是中国人";
        byte[] b = str.getBytes();
        System.out.println(b.length);
        b = str.getBytes("UTF-16LE");
        System.out.println(b.length);

        System.out.println("________________");
        //解码
        byte[] c = str.getBytes();
        String str3 = new String(c, 0, c.length, "utf-8");
        System.out.println(str3);

        //字节数不够
        str3 = new String(c, 0, c.length - 1, "utf-8");
        System.out.println(str3);

        //字符集不匹配
        str3 = new String(c, 0, c.length - 1, "gbk");
        System.out.println(str3);
    }
}
