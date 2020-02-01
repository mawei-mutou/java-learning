package date20200131;

import java.util.HashMap;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/31
 * time        : 14:51
 * description :
 */
public class TestMap2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "一", 1000);
        Employee e2 = new Employee(2, "二", 4000);
        Employee e3 = new Employee(3, "三", 8000);

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, e1);
        map.put(2, e2);
        map.put(3, e3);
        System.out.println(map);
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:" + id + "\t名字：" + name + "\t工资：" + salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
