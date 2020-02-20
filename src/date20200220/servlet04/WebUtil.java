package date20200220.servlet04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/18
 * time        : 19:48
 * description :把对应的List转换成Map,通过输入Patterns得到Class,从而可以创建对象
 */
public class WebUtil {
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> servlet = new HashMap<>();

    public WebUtil() {
    }

    public WebUtil(List<Mapping> mapps, List<Servlet2> servlets) {
        for (Mapping temp : mapps) {
            for (String str : temp.getPatterns()) {
                map.put(str, temp.getName());
            }
        }

        for (Servlet2 temp : servlets) {
            servlet.put(temp.getName(), temp.getCls());
        }
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public String getCls(String patterns) {
        String str = map.get(patterns);
        return servlet.get(str);
    }
}
