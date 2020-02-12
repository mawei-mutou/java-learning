package date20200209;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/9
 * time        : 22:03
 * description :
 */
public class Safe implements Runnable {
    private int ticketNums = 50;
    private boolean flag = true;

    public static void main(String[] args) {
        Safe safe = new Safe();
        new Thread(safe, "一").start();
        new Thread(safe, "二").start();
    }

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }

    public synchronized void test() {
        if (ticketNums <= 0) {
            flag=false;
            return;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
    }
}
