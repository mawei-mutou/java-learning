package date20200216.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 19:07
 * description :在线聊天室：服务端
 * 目标：实现多个客户可以收发多条消息
 * 问题：其他客户必须等待之前的客户退出，才能继续，排队
 */
public class Chat2 {
    public static void main(String[] args) throws IOException {
        System.out.println("------Sever------0--");
        //1、指定端口，创建服务器
        ServerSocket server = new ServerSocket(8856);

        while (true) {
            //2、阻塞式等待连接
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            boolean ifRunning = true;
            while (ifRunning) {
                //3、接受消息
                String msg = dis.readUTF();
                //4、发挥消息
                dos.writeUTF(msg);
                dos.flush();
            }
            //释放资源
            dos.close();
            dis.close();
            client.close();
        }

    }
}
