package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 18:19
 * description :
 */
public class TestStaticInner {
    public static void main(String[] args) {

        //创建静态内部类的对象
        Outer2.Inner2 inner = new Outer2.Inner2();
        //inner.Age = 4;//静态内部类不能直接使用外部类的方法和属性
    }
}

class Outer2 {
    int age = 20;

    public void Age() {
        System.out.println("外部类的方法");
    }
    static class Inner2{
        public void Age2() {
            //System.out.println("内部类的方法"+Outer2.this.age);//静态内部类不能直接使用外部类的方法和属性
        }
    }
}
