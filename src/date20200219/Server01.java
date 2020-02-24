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
 * description :目标：使用ServerSocket建立与浏览器的连接，获取请求协议
 */
public class Server01 {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server01 server = new Server01();
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

            //正文内容
            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("<终于回来了>");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length;

            StringBuilder responseInfo = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";

            //返回协议
            //1、响应行：HTTP/1.1 200 OK
            responseInfo.append("HTTP/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);

            //2、响应头（最后一行存在空行）：
            /*Date:Mon,31Dec209904:25:57GMT
              Server:shsxtServer/0.0.1;charset=GBK
              Content-type:text/html
              Content-length:39725426
             */
            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server:shsxtServer/0.0.1;charset=GBK").append(CRLF);
            responseInfo.append("Content-type:text/html").append(CRLF);
            responseInfo.append("Content-length:").append(size).append(CRLF);
            responseInfo.append(CRLF);
            //3、正文
            responseInfo.append(content.toString());
            //写出到客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(responseInfo.toString());
            bw.flush();
        } catch (IOException e) {
            System.out.println("连接失败");
        }
    }


    public void stop() {

    }
}


