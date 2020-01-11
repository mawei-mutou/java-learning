package date20200111;

import java.util.HashSet;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 16:05
 * description :
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        set1.add("aa");
        set1.add("bb");
        set1.add("aa");
        System.out.println(set1);

        set1.remove("bb");
        System.out.println(set1);


        Set<String> set2 = new HashSet<>();
        set2.add("努力");
        set2.add("奋斗");
        set1.addAll(set2);
        System.out.println(set1);
    }
}
