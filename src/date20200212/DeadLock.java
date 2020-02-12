package date20200212;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/12
 * time        : 10:59
 * description :
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "大丫");
        Makeup g2 = new Makeup(1, "二丫");
        g1.start();
        g2.start();
    }
}

//镜子
class Mirror{

}

//口红
class Lipstick{

}

//化妆
class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;
    String girl;

    public Makeup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeup();
    }

    public void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                //获得口红
                System.out.println(this.girl + "涂口红");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girl + "照镜子");
                }
            }


        } else {
            synchronized (mirror) {
                System.out.println(this.girl + "照镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                synchronized (lipstick) {
                    System.out.println(this.girl+"涂口红");
                }
            }



        }
    }
}

