package date20200220.servlet04;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 20:14
 * description :
 */
public class LoginServlet implements  Servlet{
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
