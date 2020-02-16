package date20200216.chat;

import java.io.*;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 19:08
 * description :在线聊天室：客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Client----------");
        //1、建立连接
        Socket client = new Socket("localhost", 8857);

        //2、客户端发送消息
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();

        //3、获取消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);

        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
