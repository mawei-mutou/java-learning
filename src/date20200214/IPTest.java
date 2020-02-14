package date20200214;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 15:34
 * description :IP：定位
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getAddress());
        System.out.println(addr.getHostName());


        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.169.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        addr = InetAddress.getByName("61.135.253.15");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName()); //返回 163服务器的ip:61.135.253.15

    }
}
