package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 15:54
 * description :
 */
public abstract class Animal {
    abstract public void shout();

    public void run() {
        System.out.println("一森森扽");

    }

    public static void main(String[] args) {
        Animal a = new Dog();
    }
}

class Dog extends Animal {//子类继承抽象父类，必须对父类的抽象方法进行实现
    public void shout() {
        System.out.println("汪汪汪");
    }
}
