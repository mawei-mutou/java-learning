package date20200108;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 18:36
 * description :
 */
public class TestList {
    public static void main(String[] args) {
        test3();
        }

    public  static void test1() {
        Collection<String> c = new ArrayList<>();
        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("东东东");
        c.add(("等扽"));
        System.out.println(c);
        System.out.println(c.size());

        Object[] objs = c.toArray();//将c转化为Object数组

        c.remove("东东东");
        System.out.println(c);
    }

    public static void test2() {
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("bb");
        list02.add("ee");
        System.out.println("list01:" + list01);

        //list01.addAll(list02);
        //list01.removeAll(list02);
        list01.retainAll(list02);

        System.out.println("list01:" + list01);
    }

    public static void test3() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("B");
        list.add("B");
        System.out.println(list);


        list.add(2, "我等等等");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        list.set(2, "爱来的");
        System.out.println(list);

        System.out.println(list.get(2));


        list.add("C");
        list.add("B");

        System.out.println(list);

        System.out.println(list.indexOf("B"));

        System.out.println(list.lastIndexOf("B"));

    }
}

