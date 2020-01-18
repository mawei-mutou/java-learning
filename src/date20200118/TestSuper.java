package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 23:13
 * description :
 */
public class TestSuper {
    public static void main(String[] args) {
        new ChildClass().f();
    }
}

class FatherClass {
    public int value;
    int age;

    public void f() {
        value =100;
        age =8;
        System.out.println("FatherClass.value=" + value);
    }
}

class ChildClass extends FatherClass {
    public int value;

    public void f() {
        super.f();
        value =200;
        System.out.println("ChildClass.value =" + value);
        System.out.println(value);
        System.out.println(super.value);
        System.out.println(super.age);

    }
}