package date20200215;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 23:51
 * description :基本类型：发送端
* 1、使用DatagramSocket 指定端口 创建发送端
* 2、准备数据 转成字节数组 ，需要用到DataInputStream
* 3、封装成DatagramPacket 包裹 ，需要指定目的地
* 4、发送包裹send(DatagramPacket p)
*   5、释放资源
 *
 */
public class UDPTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中......");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket send = new DatagramSocket(8887);
        //2、准备数据 转成字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream ip = new DataOutputStream(new BufferedOutputStream(baos));
        ip.writeUTF("坚持就是胜利");
        ip.write(55);
        ip.writeBoolean(false);
        ip.writeChar('a');
        ip.flush();

        byte[] datas = baos.toByteArray();
        //3、封装成DatagramPacket 包裹 ，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 9999));
        //4、发送包裹send(DatagramPacket p)
        send.send(packet);

        // 5、释放资源
        send.close();
    }
}
