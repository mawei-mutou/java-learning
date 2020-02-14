package date20200214;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 11:34
 * description :
 */
public class ThreadLocalTest01 {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();//默认为0
    //更改初始化值
    private static ThreadLocal<Integer>  threadLocal2=new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 200;
        }
    };

    //简化的方式 Lambda
    private  static ThreadLocal<Integer> threadLocal3=ThreadLocal.withInitial(()->300);


    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName()+"--->"+threadLocal3.get());

        //设置值
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());

        new Thread(new MyRun()).start();

    }

    //设置内部类
    public static class MyRun implements Runnable {
        public MyRun() {
            threadLocal.set(50);
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
            threadLocal.set((int)(Math.random()*99));
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
        }
    }
}
