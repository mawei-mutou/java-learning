package date20200208;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 10:38
 * description :
 */
public class BlockedSleep01 implements Runnable {
    private int ticketNums = 99;
    public static void main(String[] args) {
        new Thread(new BlockedSleep01(), "你").start();
        new Thread(new BlockedSleep01(), "我").start();
        new Thread(new BlockedSleep01(), "他").start();

    }

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"->"+ticketNums--);
        }
    }


}
