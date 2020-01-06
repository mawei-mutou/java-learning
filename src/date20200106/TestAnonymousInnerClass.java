package date20200106;

/**测试匿名内部类
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 18:29
 * description :
 */
public class TestAnonymousInnerClass {

    public static void test01(AA a) {
        System.out.println("$$$$$$$$$$$$$");
        a.aa();
    }

    //匿名内部类
    public static void main(String[] args) {
        TestAnonymousInnerClass.test01(new AA(){
            @Override
            public void aa(){
                System.out.println("实现匿名内部类");
            }
        });

    }
}

interface AA {
    void aa();
}