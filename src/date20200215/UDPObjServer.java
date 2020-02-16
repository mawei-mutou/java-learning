package date20200215;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 11:41
 * description :Obj：类型接受方
 */
public class UDPObjServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("接收方接受中...........");
        //1、用DatagramSocket,指定端口，创建接受端
        DatagramSocket receive = new DatagramSocket(8989);
        //2、创建容器
        byte[] datas = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);

        //3、接受数据
        receive.receive(packet);

        //4、分析数据
        byte[] tempt = packet.getData();
        ByteArrayInputStream bai = new ByteArrayInputStream(tempt);
        ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(bai));

        String st = oi.readUTF();
        int a = oi.readInt();
        Object person = oi.readObject();

        System.out.println(st);
        if (person instanceof Person) {
            Person man = (Person) person;
            System.out.println(man.getName());
        }

        //5、关闭资源
        receive.close();
    }
}
