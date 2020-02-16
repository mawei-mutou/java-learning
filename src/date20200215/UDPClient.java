package date20200215;

import java.io.IOException;
import java.net.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 23:51
 * description :发送端
* 1、使用DatagramSocket 指定端口 创建发送端
* 2、准备数据 转成字节数组
* 3、封装成DatagramPacket 包裹 ，需要指定目的地
* 4、发送包裹send(DatagramPacket p)
*   byte[] getData();
*   getLength()
*   5、释放资源
 *
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket send = new DatagramSocket(8888);
        //2、准备数据 转成字节数组
        String st = "加油干，不放弃，坚持就是胜利！！！";
        byte[] datas = st.getBytes();
        //3、封装成DatagramPacket 包裹 ，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 9999));
        //4、发送包裹send(DatagramPacket p)
        //  byte[] getData();
        //getLength()
        send.send(packet);

        // 5、释放资源
        send.close();
    }
}
