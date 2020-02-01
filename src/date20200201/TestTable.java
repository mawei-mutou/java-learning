package date20200201;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 15:24
 * description :
 */
public class TestTable {


    public static void main(String[] args) {
        Map<Integer, People> map = new HashMap<>();

        People p1 = new People(1001, "张三", 22, 20000, "2018.5.5");
        People p2 = new People(1002, "张四", 45, 50000, "2019.9.5");
        People p3 = new People(1003, "张五", 32, 3000, "2020.5.5");
        map.put(1001, p1);
        map.put(1002, p2);
        map.put(1003, p3);
        System.out.println(map);
//        List<Map> list = new ArrayList<>();
//        list.add(new HashMap<Integer,People>())
    }

}

class People {
    private int id;
    private String name;
    private int age;
    private int salary;
    private String date;

    public People(int id, String name, int age, int salary, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID:" + id + "\t姓名：" + name + "\t年龄：" + age + "\t薪水：" + salary + "\t入职日期：" + date+"\n";
    }
}
