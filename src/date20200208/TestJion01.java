package date20200208;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 15:20
 * description :
 */
public class TestJion01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("lambda..." + i);
        }
    }
    public static void main(String[] args) {

        TestJion01 t = new TestJion01();
        t.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main...." + i);
            if (i == 5) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
