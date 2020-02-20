package date20200220;

import date20200219.Response;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 12:15
 * description :目标：封装响应信息
 * 1、内容可以动态添加
 * 2、关注状态码，拼接好响应的协议信息
 *
 */
public class Server03 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server03 server = new Server03();
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
            Servlet servlet = null;
            //正文内容
            if (request2.getUrl().equals("login")) {
                servlet = new LoginServlet();
            } else if (request2.getUrl().equals("reg")) {
                servlet = new RegisterServlet();
            } else {

            }
            servlet.service(request2, response);

            response.pushToBrowser(200);

        } catch (IOException e) {
            System.out.println("连接失败");
        }

    }
    public void stop() {

    }
}


