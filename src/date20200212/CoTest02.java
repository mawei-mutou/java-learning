package date20200212;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/12
 * time        : 18:54
 * description :
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Consumers(tv).start();
    }
}

//生产者 演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("奇葩说");
            } else {
                this.tv.play("太污了。立白洗一下");
            }
        }
    }
}

//消费者  观众
class Consumers extends Thread {
    Tv tv;

    public Consumers(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
//统一资源 电视
class Tv {
    String voice;
    //信号灯 T表示演员表演，观众等待  F表示观众观看，演员等待
    boolean flag=true;

    //表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了：" + voice);
        this.voice = voice;
        this.flag = !this.flag;
        this.notifyAll();
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了" + voice);
        this.notifyAll();
        this.flag = !!this.flag;
    }
}
