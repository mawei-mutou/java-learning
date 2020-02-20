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
 * 整合配置文件
 *
 */
public class Server04 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server04 server = new Server04();
        server.start();
    }
    public void start() {
        try {
            serverSocket = new ServerSocket(8888);

        } catch (IOException e) {
            System.out.println("服务启动失败！");
        }
        receive();
    }
    public void receive() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            //获取请求协议
            Request2 request2 = new Request2(client);
            //响应消息
            Response response = new Response(client);
            Servlet servlet =WebApp.getServletFromUrl(request2.getUrl());
            if (null != servlet) {
                servlet.service(request2, response);
                response.pushToBrowser(200);

            } else {
                response.pushToBrowser(404);
            }
        } catch (IOException e) {
            System.out.println("连接失败");
        }

    }
    public void stop() {
    }
}