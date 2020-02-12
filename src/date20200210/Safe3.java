package date20200210;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/10
 * time        : 9:46
 * description :
 */
public class Safe3 implements Runnable {
    private int ticketNums = 40;
    private boolean flag=true;

    public static void main(String[] args) {
        Safe3 safe=new Safe3();
        new Thread(safe, "张三").start();
        new Thread(safe, "李四").start();
    }
    @Override
    public void run() {
        while (flag) {
            test5();
        }
    }

    //线程不安全
    public boolean test1() {
        if (ticketNums <= 0) {
            flag = false;
            return false;
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
        return flag;
    }

    //锁住了方法，但可能性能比较差
    public synchronized boolean test2() {
        if (ticketNums <= 0) {
            flag = false;
            return false;
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
        return flag;
    }

    //同步块
    public boolean test3() {
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return false;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
            }
            return flag;
        }
    }

    //线程不安全，ticketNums对象在变，synchronized只能锁住不变的对象，对象里的属性可以变
    public boolean test4() {
        synchronized ((Integer)ticketNums) {
            if (ticketNums <= 0) {
                flag = false;
                return false;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
            }
            return flag;
        }
    }

    //
    public boolean test5() {
        if (ticketNums <= 0) {//没有票的时候
            flag = false;
            return false;
        }
        synchronized (this) {//最后一张票时
            if (ticketNums <= 0) {
                flag = false;
                return false;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
            }
            return flag;
        }
    }
}


