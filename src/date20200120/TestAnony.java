package date20200120;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/20
 * time        : 20:58
 * description :
 */
public class TestAnony {

    public static void test01(AA a) {
        a.aa();
    }
    public static void main(String[] args) {
        TestAnony.test01(new AA(){
           public void aa() {
                System.out.println("内部类");
            }
        });//匿名内部类
    }
}

interface AA {
    void aa();
}
