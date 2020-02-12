package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 8:30
 * description :
 */
public class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("坚强！");
        }
    }
    public static void main(String[] args) {
        TestThread tt = new TestThread();
        tt.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("努力！");
        }
    }
}
