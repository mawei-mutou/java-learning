package date20200220.servlet04;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 20:25
 * description :
 */
public class OthersServlet implements Servlet {
    @Override
    public void service(Request2 request2, Response response) {
        response.print("其他页面");
    }
}
