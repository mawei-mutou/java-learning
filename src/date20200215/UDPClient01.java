package date20200215;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 10:40
 * description :发送方
 * 1、使用DatagramSocket创建发送端
 * 2、准备数据，转换成字节数组
 * 3、使用DatagramPacket打包，需要写上套接字
 * 4、发送数据
 * 5、关闭资源
 */
public class UDPClient01 {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中....");

        //1、使用DatagramSocket创建发送端
        DatagramSocket send = new DatagramSocket(5656);

        //2、准备数据，转换成字节数组

        String st = "不以物喜，不以己悲！做好自己！";
        byte[] datas = st.getBytes();
        // 3、使用DatagramPacket打包，需要写上套接字
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 6565));
        //4、发送数据
        send.send(packet);

        //5、关闭资源
        send.close();
    }
}
