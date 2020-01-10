package date20200110;

import java.util.HashMap;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/10
 * time        : 18:58
 * description :
 */
public class TestMap2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "东京发", 150000);
        Employee e2 = new Employee(2, "森很", 10000);
        Employee e3 = new Employee(3, "雄风", 850000);


        Map<Integer, Employee> map = new HashMap<>();

        map.put(001, e1);
        map.put(002, e2);
        map.put(003, e3);

        Employee emp = map.get(001);
        System.out.println(emp.getEname());

        System.out.println(map);


    }
}

//员工信息
class Employee {

    private int id;
    private String ename;
    private double salary;

    public Employee(int id, String ename, double salary) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id: "+id+" name: "+ename+"\t"+" 工资："+salary+"\t";
    }
}

