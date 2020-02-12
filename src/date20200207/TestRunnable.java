package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 9:15
 * description :
 */
public class TestRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("坚持！");
        }
    }
    public static void main(String[] args) {
        TestRunnable tr = new TestRunnable();
        Thread is = new Thread(tr);
        is.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("逝去的青春！！");
        }
    }
}
