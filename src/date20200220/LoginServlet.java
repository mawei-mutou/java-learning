package date20200220;

import date20200219.Response;
import date20200220.Request2;
import date20200220.Servlet;

import java.io.IOException;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 14:02
 * description :
 */
public class LoginServlet implements Servlet {
//    private Request2 request2;
//    private Response response;
//    public LoginServlet(Socket client) throws IOException {
//        request2 = new Request2(client);
//        response = new Response(client);
//    }
    @Override
    public void service(Request2 request2, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("服务器响应成功" );
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("欢迎回来："+request2.getParameterValue("uname"));
        response.print("</body>");
        response.print("</html>");
    }
}
