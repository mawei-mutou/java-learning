package yzbtest.date20200111;

import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        List<String> datas = Arrays.asList("aa,bb,cc.dd".split(","));
        Iterator<String> iter = datas.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        // java8 新特性 lambda表达式
        datas.forEach(s->{
            System.out.println(s);
        });
        // java8 新特性 lambda表达式+方法调用（仅作了解）
        datas.forEach(System.out::println);

        for(int i=0;i<datas.size();i++){
            // for循环 不能用来遍历set
        }

        Set<String> stringSet =new HashSet<>();
//        stringSet.iterator()


    }
}
