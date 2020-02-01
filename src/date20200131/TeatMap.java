package date20200131;

import java.util.HashMap;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/31
 * time        : 14:15
 * description :
 */
public class TeatMap {

    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");


        System.out.println(m1);

        System.out.println(m1.get(1));
        System.out.println(m1.getClass());
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsValue("one"));

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(4, "四");
        m2.put(5, "五");

        m1.putAll(m2);
        System.out.println(m1);
        m1.put(3, "三");
        System.out.println(m1);

    }
}
