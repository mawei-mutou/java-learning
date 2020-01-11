package date20200111;

import java.util.Map.*;
import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 17:54
 * description :
 */
public class TestIterator {
    public static void main(String[] args) {

        testIteratorList();
        testIteratorSet();

        testIteratorMap();
    }
    public static void testIteratorList() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");


        //使用iterator遍历List
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {

            String temp = iter.next();
            System.out.println(temp);

        }
    }

    public static void testIteratorSet() {
        Set<String> set = new HashSet<>();

        set.add("三扽就");
        set.add("森asf");
        set.add("c三扽森");
        set.add("色的");


        //使用iterator遍历List
        for (Iterator<String> iter = set.iterator(); iter.hasNext(); ) {

            String temp = iter.next();
            System.out.println(temp);
        }
    }


    public static void testIteratorMap() {
        Map<Integer,String> m = new HashMap<>();
        m.put(1,"三扽就");
        m.put(12,"当");
        m.put(17,"柴火");
        m.put(254,"帮爷爷");
        m.put(7,"的疼给");

        Set<Entry<Integer, String>> ss = m.entrySet();
        //使用iterator遍历List
        for (Iterator<Entry<Integer,String>> iter = ss.iterator(); iter.hasNext(); ) {
            Entry<Integer,String>  temp = iter.next();
            System.out.println(temp.getKey() + "--" + temp.getValue());
        }
    }
}

