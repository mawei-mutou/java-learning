package date20200129;

import java.util.ArrayList;
import java.util.Collection;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/29
 * time        : 21:32
 * description :
 */
public class TestCollection {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Collection<String> d = new ArrayList<>();
        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("aaa");
        c.add("bbb");
        d.add("aaa");
        d.add("我");
        d.add("爱");
        d.add("你");
        c.addAll(d);
        System.out.println(c);
        //c.removeAll(d);
        //System.out.println(c);
        c.retainAll(d);
        System.out.println(c);

        System.out.println(c);
        System.out.println(c.size());

        Object objs = c.toArray();
        System.out.println(objs);

        System.out.println("是否包含"+c.contains("aa"));
        c.remove("aaa");
        System.out.println(c);

        c.clear();
        System.out.println(c.size());
    }
}
