package date20200201;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 12:12
 * description :
 */
public class TestIterator1 {
    public static void main(String[] args) {
        TestIterator1.TestIteratorSet();
    }

    public static void TestIteratorSet() {
        Set<String> set = new HashSet<>();

        set.add("aa");
        set.add("bb");
        set.add("cc");

        for (Iterator iter = set.iterator(); iter.hasNext();) {
            String temp = (String) iter.next();
            System.out.println(temp);
        }
    }
}
