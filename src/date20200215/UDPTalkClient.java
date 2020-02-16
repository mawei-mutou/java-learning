package date20200215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 23:51
 * description :实现多次发送 的发送端
* 1、使用DatagramSocket 指定端口 创建发送端
* 2、准备数据 转成字节数组
* 3、封装成DatagramPacket 包裹 ，需要指定目的地
* 4、发送包裹send(DatagramPacket p)
*   byte[] getData();
*   getLength()
*   5、释放资源
 *
 */
public class UDPTalkClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket send = new DatagramSocket(8888);
        //2、准备数据 转成字节数组
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String st = read.readLine();
            byte[] datas = st.getBytes();
            //3、封装成DatagramPacket 包裹 ，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                    new InetSocketAddress("localhost", 9999));
            //4、发送包裹send(DatagramPacket p)
            //  byte[] getData();
            //getLength()
            send.send(packet);
            if (st.equals("bye")) {
                break;
            }
        }

        // 5、释放资源
        send.close();
    }
}
