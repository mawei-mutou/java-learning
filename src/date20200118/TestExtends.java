package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 22:24
 * description :
 */
public class TestExtends {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "高淇";
        stu.height = 12;
        stu.rest();

        Student stu2 = new Student("姚大", "土木", 187);
        System.out.println(stu2 instanceof Student);
        System.out.println(stu2 instanceof Person);
        System.out.println(stu2 instanceof Object);
    }
}

class Person {
    String name;
    int height;

    public void rest() {
        System.out.println("休息一会！");

    }
}

class Student extends Person {
    String major;

    public void study() {
        System.out.println("努力学习！");

    }

    Student() {
    }

    public Student(String name, String major, int height) {
        this.major = major;
        this.height = height;
        this.name = name;
    }
}
