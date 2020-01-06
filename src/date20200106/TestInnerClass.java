package date20200106;

/**测试非静态内部类
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 18:10
 * description :
 */
public class TestInnerClass {
    public static void main(String[] args) {
        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        Outer outer = new Outer();
    }
}

class Outer {
    private int age = 18;

    private void testOuter() {
    }

    class Inner{
        int age = 20;

        public void show() {
            int age = 30;
            System.out.println("外部类的成员变量age:" + Outer.this.age);
            System.out.println("内部类的成员变量age：" + this.age);
            System.out.println("局部变量age:" + age);
        }
    }
}