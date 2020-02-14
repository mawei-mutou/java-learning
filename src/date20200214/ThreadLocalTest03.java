package date20200214;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 12:50
 * description :分析上下文，环境
 */
public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        new Thread(new MyRun()).start();

    }


    public static class MyRun implements Runnable {

        public MyRun() {
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());//这里的Thread.currentThread().getName()时main的
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"剩下-->"+threadLocal.get());
        }
    }
}
