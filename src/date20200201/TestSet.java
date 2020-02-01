package date20200201;

import java.util.HashSet;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 11:40
 * description :
 */
public class TestSet {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("aaa");
        System.out.println(set);

        set.remove("aaa");
        System.out.println(set);


        Set set2 = new HashSet();
        set2.add("二从 njk");

        set2.addAll(set);
        System.out.println(set2);
    }
}
