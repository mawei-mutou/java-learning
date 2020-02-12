package date20200208;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 16:50
 * description :
 */
public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp, "一");
        Thread t2 = new Thread(mp, "二");
        Thread t3 = new Thread(mp, "三");
        Thread t4 = new Thread(mp, "四");
        Thread t5 = new Thread(mp, "五");
        Thread t6 = new Thread(mp, "六");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(10);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
