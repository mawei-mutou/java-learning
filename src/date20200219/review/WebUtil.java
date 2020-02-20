package date20200219.review;

import date20200219.Mapping;
import date20200219.Servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 10:26
 * description :
 */
public class WebUtil {
    private Map<String, String> map = null;
    private Map<String, String> servlet = null;
    List<Mapping> mappings;
    List<Servlet> servlets;


    public WebUtil() {
    }

    public WebUtil(List<Mapping> mappings, List<Servlet> servlets) {
        map = new HashMap<String, String>();
        servlet = new HashMap<String, String>();
        this.mappings = mappings;
        this.servlets = servlets;

        for (Mapping mapping : mappings) {
            for (String patterns : mapping.getPatterns()) {
                map.put(patterns,mapping.getName());
            }
        }

        for (Servlet temp: servlets) {
            servlet.put(temp.getName(), temp.getCls());
        }
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public String getCls(String url) {
        String str = map.get(url);
        return servlet.get(str);
    }
}
