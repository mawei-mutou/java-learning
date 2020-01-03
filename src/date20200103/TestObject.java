package date20200103;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 13:41
 * description :
 */
public class TestObject {
    public static void main(String[] args) {
       // Object obj;
        TestObject to = new TestObject();
        System.out.println(to.toString());

        Person2 p2 = new Person2("小样", 18);
        System.out.println(p2);
    }

    public String toString() {
        return "测试Object对象";
    }
}

class Person2 {
    String name;

    public Person2(String name) {
        this.name = name;
    }

    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    @Override//非注释性语句
//    public String toString() {
//        return "姓名：" + name + "，年龄：" + age;
//    }

//    public Person2(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    public Person2() {
    }
}
