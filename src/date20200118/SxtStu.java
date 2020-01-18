package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 19:29
 * description :
 */
public class SxtStu {
    //uux;
    int id;
    String name;
    int age;
    Computer comp;

    //方法
    void study() {
        System.out.println("我在学习" + comp.brand);
    }

    void play() {
        System.out.println("我在玩游戏");

    }

    public static void main(String[] args) {
        SxtStu stu = new SxtStu();
        stu.name = "yaodong";
        stu.id = 1004;

        Computer computer = new Computer();
        computer.brand = "联想";
        stu.comp = computer;
        stu.play();
        stu.study();
    }
}

class Computer {
    String brand;
}