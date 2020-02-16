package date20200216;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 14:25
 * description :
 */
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(9998);
        boolean isRunning =true;

        while (isRunning) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            new Thread(new Channel(client)).start();
        }
        server.close();
    }

    static class Channel implements Runnable {
        private Socket client;
        private DataInputStream dis;//输入流
        private  DataOutputStream dos;//输出流


        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                //String datas = dis.readUTF();

            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        //接受数据
        private String receive() {
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        //发送数据
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //关闭资源
        private void release() {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        @Override
        public void run() {
            String name = "";
            String upwd = "";
            //分析数据
            String[] dataArrays = receive().split("&");
            for (String temp : dataArrays) {
                String[] uInfo = temp.split("=");
                if (uInfo[0].equals("uname")) {
                    System.out.println("输入的名字为：" + uInfo[1]);
                    name = uInfo[1];
                } else if (uInfo[0].equals("upwd")) {
                    System.out.println("输入的密码为：" + uInfo[1]);
                    upwd = uInfo[1];
                }
            }
            if (name.equals("yaodong") && upwd.equals("123456")) {
                send("登录成功，欢迎回来！");
            } else {
                send("登陆失败！");
            }
            release();
        }
    }
}
