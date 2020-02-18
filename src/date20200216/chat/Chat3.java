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
 * 加入多线程，不必排队
 * 问题：代码不会维护。客户端读写没有分开，必须先写后读
 */
public class Chat3 {
    public static void main(String[] args) throws IOException {
        System.out.println("------Sever------0--");
        //1、指定端口，创建服务器
        ServerSocket server = new ServerSocket(8556);

        while (true) {
            //2、阻塞式等待连接
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");

            new Thread(()->{
                DataInputStream dis = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    //3、接受消息
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                        //4、发送消息
                        dos.writeUTF(msg);
                        dos.flush();
                    } catch (IOException e) {
                        isRunning =false;//停止线程
                    }
                }
                //释放资源
                try {
                    if (dos != null) {
                        dos.close();
                    }
                    if (dis != null) {
                        dis.close();
                    }
                    if (client != null) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
