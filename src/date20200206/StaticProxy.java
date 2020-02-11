package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 17:54
 * description :静态代理
 */
public class StaticProxy {
    public static void main(String[] args) {
       new WeddingCompany(new You()).happyMarry();
        System.out.println(new You() instanceof Marry);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("pass");
            }
        };
        Runnable runnable1 = ()-> System.out.println("pass");


    }
}

interface Marry {
    public void happyMarry();
}

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("我来了！");
    }
}

class WeddingCompany implements Marry {
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    public void ready() {
        System.out.println("开始");
    }

    public void after() {
        System.out.println("结束");
    }
}
