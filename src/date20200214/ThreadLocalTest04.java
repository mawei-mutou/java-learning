package date20200214;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 12:56
 * description :InheritableThreadLocal能继承上下文环境的数据，复制一份给子线程
 */
public class ThreadLocalTest04 {
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set(2);

        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        new Thread(() -> {
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
        }).start();
    }
}
