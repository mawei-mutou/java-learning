package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 9:48
 * description :
 */
public class Wedding {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany wed = new WeddingCompany(you);
        wed.happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("结婚吧！");
    }
}
class WeddingCompany implements Marry {
    private Marry you;

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    @Override
    public void happyMarry() {
        start();
        this.you.happyMarry();
        end();
    }

    public void start() {
        System.out.println("huxy");
    }

    public void end() {
        System.out.println("yd");
    }
}
