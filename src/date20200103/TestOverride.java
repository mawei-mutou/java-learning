package date20200103;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 11:47
 * description :
 */
public class TestOverride {

}

class Vehicle {
    public void run() {
        System.out.println("跑。。。");

    }

    public void stop() {
        System.out.println("停止！");

    }

    public Person whoIsPsg() {
        return new Person();//返回person类型
    }
}

class Horse extends Vehicle{
    public void run() {
        System.out.println("马不停蹄，飞速奔跑！");//子类对父类的方法重写需要保持方法名和参数完全一致
    }

    public Student whoIsPsg() {
        return new Student();//子类
    }
}
