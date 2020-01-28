package date20200120;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/20
 * time        : 20:30
 * description :
 */
public class TestStatic {
    public static void main(String[] args) {
        Outer.Iner1 a = new Outer().new Iner1();
        a.Str();
        Outer.Iner2 b = new Outer.Iner2();
        b.Str2();
    }
}

class Outer {
    int age;
    String name;
    boolean isMan;

    public void Str3() {
        System.out.println("外部方法");
    }

    class Iner1 {
         String major;
         int aaa = Outer.this.age;
        public void Str() {
            System.out.println("内部类");
        }

    }


    static class Iner2 {
        int length;
        public void Str2() {
            System.out.println("内部静态类");
        }
    }
}
