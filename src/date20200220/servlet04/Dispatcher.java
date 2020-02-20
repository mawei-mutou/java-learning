package date20200220.servlet04;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 20:56
 * description :
 */
public class Dispatcher implements Runnable {
    private Request2 request2;
    private Response response;
    private Socket client;
    private Servlet servlet;

    public Dispatcher(Socket client) {
        this.client = client;
        //获取请求协议
        //响应消息
        try {
            request2 = new Request2(client);
            response = new Response(client);
            servlet =WebApp.getServletFromUrl(request2.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }

    }
    @Override
    public void run() {

        try {
            if (null == request2.getUrl() || request2.getUrl().equals("")) {
                byte[] datas = new byte[1024 * 10];
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200220/servlet041/error3.html");
                String str = new String(String.valueOf(is.read(datas, 0, datas.length)));
                response.print(str);
                response.pushToBrowser(200);
                return;
            }else {
                if (null != servlet) {
                servlet.service(request2, response);
                response.pushToBrowser(200);

                } else {
                    byte[] datas = new byte[1024 * 10];
                    InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200220/servlet041/error.html");
                    String str = new String(String.valueOf(is.read(datas, 0, datas.length)));
                    response.print(str);
                    response.pushToBrowser(404);
                }
            }
        } catch (IOException e) {
            try {
                byte[] datas = new byte[1024 * 10];
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200220/servlet041/error2.html");
                String str = new String(String.valueOf(is.read(datas, 0, datas.length)));
                response.print(str);
                response.pushToBrowser(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        release();
    }

    public void release() {
        try {
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
