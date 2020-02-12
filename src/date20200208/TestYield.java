package date20200208;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 12:22
 * description :
 */
public class TestYield {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                System.out.println("yield..." + i);
            }
        }).start();

        for (int i = 1; i <= 30; i++) {
            if (i % 5 == 0) {
                Thread.yield();            }
            System.out.println("main...."+i);
        }
    }
}
