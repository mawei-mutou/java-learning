package date20200213;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 11:58
 * description :每个线程自身的数据更改不会影响其他线程
 */
public class ThreadLocalTest02 {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }
    }


    public static class MyRun implements Runnable {
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "获得--->" + left);
            threadLocal.set(left - 1);
            System.out.println(Thread.currentThread().getName()+"剩下-->"+threadLocal.get());
        }
    }
}
