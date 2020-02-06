package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 16:27
 * description :
 */
public class Web12306 implements Runnable {
    private int ticketNums = 99;
    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            } else {
                System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Web12306 wb = new Web12306();
        new Thread(wb, "张三").start();
        new Thread(wb, "李四").start();
        new Thread(wb, "王五").start();

    }
}
