package date20200111;

import java.lang.String;

import java.util.Set;
import java.util.TreeSet;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 16:41
 * description :
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(300);
        set.add(200);
        set.add(600);

        for (Integer temp : set) {
            System.out.println(temp);
        }
        Set<Emp2> set2 = new TreeSet<>();
        set2.add(new Emp2(19, "我", 18000));
        set2.add(new Emp2(36, "我", 14000));
        set2.add(new Emp2(25, "我", 78000));
        set2.add(new Emp2(45, "我", 13000));
        set2.add(new Emp2(35, "我", 32000));
            System.out.println(set2);
    }

}

class Emp2 implements Comparable<Emp2> {
    int age;
    String name;
    double salary;

    public Emp2(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp2 o) {
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }

    }
    @Override
    public String toString(){
        return "name:" + name + "  age:" + age + "  salary:" + salary;
    }
}
