package date20200216.chat;

import java.io.*;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 19:08
 * description :在线聊天室：客户端
 * 实现多个客户可以收发多条消息
 *  * 问题：其他客户必须等待之前的客户退出，才能继续，排队
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Client----------");
        //1、建立连接
        Socket client = new Socket("localhost", 8856);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        boolean isRunning =true;
        while (isRunning) {
            //2、客户端发送消息
            String msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();

            //3、获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }


        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
