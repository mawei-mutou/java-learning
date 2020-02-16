package date20200215;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 23:52
 * description :多次接受端
 * 1、使用DatagramSocket 指定端口 创建接受端
 * 2、准备容器 封装成DatagramPacket 包裹
 * 3、阻塞式接受包裹receive（DatagramPacket p）
 * 4、分析数据
 *   byte[] getData();
 *   getLength()
 *   5、释放资源
 *
 */
public class UDPTalkServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中。。。");

        //1、使用DatagramSocket 指定端口 创建接受端
        DatagramSocket receive = new DatagramSocket(9999);
        while (true) {
            //2、准备容器 封装成DatagramPacket 包裹
            byte[] datas = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);

            // 3、阻塞式接受包裹receive（DatagramPacket p）
            receive.receive(packet);
            // 4、分析数byte[] getData();
            // getLength()
            byte[] temp = packet.getData();
            int len = packet.getLength();
            String st = new String(temp, 0, temp.length);
            System.out.println(st);

            if (st.equals("bye")) {
                break;
            }
        }

        //5、释放资源
        receive.close();
    }
}
