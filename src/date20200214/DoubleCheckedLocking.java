package date20200214;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/13
 * time        : 10:35
 * description :单例模式
 */
public class DoubleCheckedLocking {

    //私有的静态属性
    private static volatile DoubleCheckedLocking instance;//如果不加入volatile可能因为指令重排，其它线程拿到空指针
    private static  DoubleCheckedLocking instance1;//如果不加入volatile可能因为指令重排，其它线程拿到空指针

    //私有的构造方法
    private DoubleCheckedLocking() {
    }

    //公共的静态方法：通过它来访问静态的属性
    public static DoubleCheckedLocking getInstance(int time) {
        if (null != instance) {
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (null == instance) {
                instance = new DoubleCheckedLocking();

            }
        }
        return instance;
    }

    //不加synchronized会导致对外不止一个对象
    public static DoubleCheckedLocking getInstance1(int time) {
        if (null != instance1) {
            return instance1;
        }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (null == instance1) {
                instance1 = new DoubleCheckedLocking();

            }
        return instance1;
    }


    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(DoubleCheckedLocking.getInstance(5000));
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstance(7000));
        System.out.println("------------------------end-------------");
        Thread t2 = new Thread(() -> {
            System.out.println(DoubleCheckedLocking.getInstance1(5000));
        });
        t2.start();
        System.out.println(DoubleCheckedLocking.getInstance1(100));

    }
}
