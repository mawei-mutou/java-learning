package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 22:02
 * description :
 */
public class LambdaTest04 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("我");
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("你");
            }
        }).start();
    }
}
