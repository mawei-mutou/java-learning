package date20200103;

/**构造方法会依次追溯到最开始的类再依次执行
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 15:34
 * description :
 */
public class TestSuper02 {
    public static void main(String[] args) {
        System.out.println("开始创建一个ChildClass对象。。。。");
        new ChildClass02();
    }
}

//创建类
class FatherClass02 {
    //创建构造方法
    public FatherClass02() {
        System.out.println("创建FatherClass02");
    }
}

class FatherClass03 extends FatherClass02 {
    //创建构造方法
    public FatherClass03() {
        System.out.println("创建FatherClass03");
    }
}

class ChildClass02 extends FatherClass03{//继承FC02
    //创建构造方法
    public ChildClass02() {
        super();//不写系统会自动运行
        System.out.println("创建ChildClass");
    }
}
