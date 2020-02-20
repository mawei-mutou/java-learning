package date20200219;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

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
public class Server02 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server02 server = new Server02();
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
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024 * 1024];
            int len = is.read(datas);
            System.out.println(new String(datas, 0, len));

            //响应消息
            Response response = new Response(client);
            //正文内容
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("<终于回来了>");
            response.print("</body>");
            response.print("</html>");

            response.pushToBrowser(200);

        } catch (IOException e) {
            System.out.println("连接失败");
        }

    }
    public void stop() {

    }
}


