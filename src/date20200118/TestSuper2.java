package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 23:30
 * description :
 */
public class TestSuper2 {
    public static void main(String[] args) {
        System.out.println("开始创建一个ChildClass对象///");
        new CC();
    }
}

class FatherClass2 {


    public FatherClass2() {
        System.out.println("创建FatherClass");
    }
}

class ChildClass2 extends FatherClass2 {
    public ChildClass2() {
        System.out.println("创建ChildClass");

    }

}


class CC extends ChildClass2 {
    public CC() {
        System.out.println("创建CC");
    }
}
