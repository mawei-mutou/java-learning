package date20200220;

import date20200219.Response;

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
        response.print("注册成功！ ");
    }
}
