package date20200217;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 19:07
 * description :在线聊天室：服务端
 * 目标：实现多个客户可以收发多条消息
 * 问题：其他客户必须等待之前的客户退出，才能继续，排队
 * 加入多线程，不必排队
 * 问题：代码不会维护。客户端读写没有分开，必须先写后读(使用封装去解决)
 *
 * 加入容器，实现群聊给其他人发消息。
 */
public class Chat4 {
    private static CopyOnWriteArrayList<Running>all=new CopyOnWriteArrayList<Running>();
    public static void main(String[] args) throws IOException {
        System.out.println("------Sever--------");
        //1、指定端口，创建服务器
        ServerSocket server = new ServerSocket(8268);

        while (true) {
            //2、阻塞式等待连接
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            Running r = new Running(client);
            all.add(r);
            new Thread(r).start();
        }
    }

    static class Running implements Runnable {
        private DataInputStream dis = null;
        private DataOutputStream dos = null;
        private Socket client;
        private boolean isRunning;
        private String name;

        public String getName() {
            return name;
        }

        public Running(Socket client){
            this.client = client;
            //输入流,输出流
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                this.name = receive();
                this.send("欢迎加入！");
                this.sendOthers(name + "进入了聊天室", true);

            } catch (IOException e) {
                System.out.println("-------------1------------------");
                release();
            }
        }

        //接收消息
        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("---------2------------");
                release();
            }
            return msg;
        }

        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("-----------3-------------");
                release();
            }
        }

        private void sendOthers(String msg,boolean isSys) {
            //私聊：约定数据格式：@xxx:msg
            boolean isPrivate = msg.startsWith("@");
            if (isPrivate) {
                int index = msg.indexOf("：");
                String targetName = msg.substring(1, index);
               // System.out.println(targetName);
                String str = msg.substring(index + 1);
                //System.out.println(msg);

                for (Running others : all) {
                    if (others.name.equals(targetName)) {
                        others.send(this.name + "对您说：" + str);
                        break;
                    }
                }
            } else {
                for (Running others : all) {
                    if (others == this) {
                        continue;
                    }
                    if (!isSys) {
                        others.send(this.name + "：" + msg);
                    } else {
                        others.send(msg);

                    }
                }
            }
        }

        //释放资源
        private void release() {
            this.isRunning = false;
            Utils.close(dos, dis, client);
            all.remove(this);
        }

        @Override
        public void run() {

            while (isRunning) {
                String mag = receive();
                System.out.println("收到的msg为："+mag);

                if (!mag.equals("")) {
                        sendOthers(mag,false);
                    }
                }
            }
        }
    }