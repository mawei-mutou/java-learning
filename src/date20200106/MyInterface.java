package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 16:17
 * description :
 */
public interface MyInterface {
    int MAX_AGE = 100;//接口中的属性一定是常量，为public static final,写不写都一样，默认的

    void test01();//public static写不写都一样，默认为public static
}

class MyClass implements MyInterface {
    @Override
    public void test01() {
        System.out.println(MAX_AGE);
        System.out.println("我的第一个实现接口的类");
    }
}
