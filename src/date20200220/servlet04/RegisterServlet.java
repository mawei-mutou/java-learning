package date20200220.servlet04;

import date20200220.servlet04.Response;
import date20200220.servlet04.Request2;
import date20200220.servlet04.Servlet;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 14:03
 * description :
 */
public class RegisterServlet implements Servlet {
    @Override
    public void service(Request2 request2, Response response) {
        response.print(request2.getParameterValue("uname")+"注册成功！ ");
    }
}
