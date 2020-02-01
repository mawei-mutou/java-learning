package date20200201;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 12:05
 * description :
 */
public class TestIterator {
    public static void main(String[] args) {
        TestIterator.test();
    }

    public static void test() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String temp = iter.next();
            System.out.println(temp);
        }

    }
}
