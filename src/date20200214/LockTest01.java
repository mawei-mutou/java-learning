package date20200214;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 21:19
 * description :
 */
public class LockTest01 {
    public void test() {
        //第一次获得锁
        synchronized (this) {
            while (true) {
                //第二次获得锁
                synchronized (this) {
                    System.out.println("ReentrantLick!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        new LockTest01().test();
    }
}
