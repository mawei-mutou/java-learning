package date20200201;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 14:58
 * description :
 */
public class Test {
    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            aList.add("a"+i);
        }
        System.out.println(aList);
        Collections.shuffle(aList);
        System.out.println(aList);
        Collections.sort(aList);
        System.out.println(aList);
        Collections.reverse(aList);
        System.out.println(aList);
        System.out.println(Collections.binarySearch(aList,"a3"));
        Collections.fill(aList, "hello");
        System.out.println(aList);

    }
}
