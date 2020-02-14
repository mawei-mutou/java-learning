package date20200214;

import java.util.concurrent.locks.ReentrantLock;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 22:30
 * description :
 */
public class LockTest04 {

    ReentrantLock lock = new ReentrantLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());

        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());

    }

    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());

        lock.unlock();
        System.out.println(lock.getHoldCount());

    }
    public static void main(String[] args) throws InterruptedException {

        LockTest03 test = new LockTest03();
        test.a();

        Thread.sleep(1000);
        System.out.println(test.lock.getHoldCount());
    }
}
