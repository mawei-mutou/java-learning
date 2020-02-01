package date20200201;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 12:23
 * description :
 */
public class TestIteratorMap {
    public static void main(String[] args) {
        TestIteratorMap.TeatIteratorMap();
    }

    public static void TeatIteratorMap() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "dee");
        map.put(2, "dsd");
        map.put(3, "sdc");
        map.put(4, "dee");
        Set<Map.Entry<Integer, String>> ss = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iter = ss.iterator(); iter.hasNext(); ) {
            Map.Entry<Integer, String> temp = iter.next();
            System.out.println("key:" + temp.getKey() +"---"+"value:" + temp.getValue());

        }

    }
}
