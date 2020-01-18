package yzbtest.date20200111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSort {
    public static void main(String[] args) {

        List<Integer> datas = Stream.of(9,8,1123,7,1,2,3,4,5,6).collect(Collectors.toList());
        datas.forEach(System.out::println);
        System.out.println("-----------------------------");
        datas.sort(Comparator.naturalOrder());
        datas.forEach(System.out::println);
        System.out.println("-----------------------------");
        datas.sort(Comparator.reverseOrder());
        datas.forEach(System.out::println);

        List<Test1> datas2 = new ArrayList<>();
        datas2.add(new Test1("ccc", 28));
        datas2.add(new Test1("aaa", 23));
        datas2.add(new Test1("bbb", 25));

        System.out.println("-----------------------------");
        datas2.sort(new Comparator<Test1>() {
            // 自定义的排序方式 会按照该方式进行排序
            @Override
            public int compare(Test1 o1, Test1 o2) {
                if(o1.getAge()>o2.getAge()){
                    return 1;
                }else if (o1.getAge()<o2.getAge()){
                    return -1;
                }
                return 0;
            }
        });

        for (Test1 test1: datas2){
            System.out.println(test1);
        }

    }
}

class Test1{
    private String name;
    private int age;


    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
