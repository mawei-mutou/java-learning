package date20200215;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 23:52
 * description :基本类型：接受端
 * 1、使用DatagramSocket 指定端口 创建接受端
 * 2、准备容器 封装成DatagramPacket 包裹
 * 3、阻塞式接受包裹receive（DatagramPacket p）
 * 4、分析数据
 *  用DataInputStream读取
 *   5、释放资源
 *
 */
public class UDPTypeServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中....");

        //1、使用DatagramSocket 指定端口 创建接受端
        DatagramSocket receive = new DatagramSocket(9999);

        //2、准备容器 封装成DatagramPacket 包裹
        byte[] datas = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);


        // 3、阻塞式接受包裹receive（DatagramPacket p）
        receive.receive(packet);

        // 4、分析数
        byte[] temp = packet.getData();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(temp)));

        String st = dis.readUTF();
        int a = dis.readInt();
        boolean b = dis.readBoolean();
        char c = dis.readChar();

//        ip.writeUTF("坚持就是胜利");
//        ip.write(55);
//        ip.writeBoolean(false);
//        ip.writeChar('a');
//        ip.flush();
        System.out.println(st);
        System.out.println(a);
        System.out.println(b);
        //5、释放资源
        receive.close();
    }
}
