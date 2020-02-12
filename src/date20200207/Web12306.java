package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 9:21
 * description :
 */
public class Web12306 implements Runnable {
    private int ticketNums=99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"->"+ticketNums--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        Thread web1 = new Thread(web, "一号抢票!");
        Thread web2 = new Thread(web, "二号抢票!");
        Thread web3 = new Thread(web, "三号抢票！");

        web1.start();
        web2.start();
        web3.start();
    }
}
