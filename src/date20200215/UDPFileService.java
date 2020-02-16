package date20200215;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 12:51
 * description :
 */
public class UDPFileService {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方接受中....");
        DatagramSocket receive = new DatagramSocket(9989);
        byte[] datas = new byte[1024 * 10];

        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);
        File file = new File("UDPcopy.jpg");
        OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
        receive.receive(packet);

        byte[] tempt = packet.getData();
        os.write(tempt, 0, tempt.length);
        os.flush();
        receive.close();


    }
}
