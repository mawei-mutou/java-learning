package date20200215;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 12:50
 * description :文件类：接收方
 */
public class UPDFileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方发送中...");
        //1、创建发送方
        DatagramSocket send =new DatagramSocket(8808);
        //2、准备数据 -->把文件转成字节数组


        File file = new File("C:\\Users\\MrYou\\Desktop\\java-learning\\timg.jpg");
        InputStream is = new BufferedInputStream(new  FileInputStream(file));

        byte[] flush = new byte[1024 * 20];
        int len = -1;

        DatagramPacket packet = new DatagramPacket(flush,0,flush.length,
                new InetSocketAddress("localhost",9989));

        while ((len = is.read(flush)) != -1) {
            send.send(packet);
        }

        send.close();
    }
}
