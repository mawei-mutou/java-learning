package date20200111;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 20:16
 * description :
 */
public class TestStoreDate2 {
    public static void main(String[] args) {

        User user1 = new User(101, "张三", 10000);
        User user2 = new User(102, "五五", 2000);
        User user3 = new User(103, "王麻子", 2999);

        List<User> users = new ArrayList<>();


        users.add(user1);
        users.add(user2);
        users.add(user3);

        for (User temp : users) {
            System.out.println(temp);
        }

        //Map
        Map<Integer, User> m = new HashMap<>();

        m.put(user1.getId(), user1);
        m.put(user2.getId(), user2);
        m.put(user3.getId(), user3);

        Set<Integer> sets = m.keySet();

        for (Integer temp : sets) {
            System.out.println(m.get(temp));
        }
    }
}

// 这是一个bean
class User {
    private int id;
    private String name;
    private double salary;

    public User(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "id:" +id + "\tname:" + name+ "\tsalary:" + salary;
    }
}
