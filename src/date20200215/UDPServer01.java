package date20200215;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 10:41
 * description :接收方
 * 1、使用DatagramSocket创建接受端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接受包裹receive
 * 4、分析数据
 * 5、关闭资源
 */
public class UDPServer01 {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中.....");
        //1、使用DatagramSocket创建接受端
        DatagramSocket receive = new DatagramSocket(6565);
        //2、准备容器，封装成DatagramPacket包裹
        byte[] datas = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);
        //3、阻塞式接受包裹receive
        receive.receive(packet);
        //4、分析数据
        byte[] temp = packet.getData();
        System.out.println(new String(temp, 0, temp.length));
        //5、关闭资源
        receive.close();
    }
}
