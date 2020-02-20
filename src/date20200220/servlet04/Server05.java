package date20200220.servlet04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 12:15
 * description :目标：封装响应信息
 * 加入分发器(加入多线程)
 *
 */
public class Server05 {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public static void main(String[] args) {
        Server05 server = new Server05();
        server.start();
    }
    public void start() {
        isRunning=true;
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            System.out.println("服务启动失败！");
            stop();
        }
        receive();
    }
    public void receive() {
        while (isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接");

                //多线程
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                System.out.println("连接失败");
            }
        }
    }

    public void stop() {
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}