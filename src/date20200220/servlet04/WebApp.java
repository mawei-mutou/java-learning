package date20200220.servlet04;

import date20200218.LoginServlet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 17:59
 * description :
 */
public class WebApp {

    private static WebUtil contents;
    static {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            WebHander2 hander = new WebHander2();
            parser.parse(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("date20200220/servlet04/web.xml"), hander);
            List<Mapping> mapps = hander.getMapps();
            List<Servlet2> servlets = hander.getServlets();
            contents = new WebUtil(mapps, servlets);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //通过url获取配置文件对应的servlet
    public static Servlet getServletFromUrl(String url) {
        String cls = contents.getCls("/"+url);
        System.out.println(cls);
        Class c = null;
        try {
            c = Class.forName(cls);
            Servlet servlet = (Servlet) c.getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//        String cls = contents.getCls("/login");
//        System.out.println(cls);
//        Class c = Class.forName(cls);

//        LoginServlet login = (LoginServlet) c.getConstructor().newInstance();
//        login.service();
}
