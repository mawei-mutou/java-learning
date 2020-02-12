package date20200208;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 15:28
 * description :
 */
public class TestJion02 {
    public static void main(String[] args) {
        new Father().start();
    }
}

class Father extends Thread {
    @Override
    public void run() {
        System.out.println("我想抽烟，发现烟没有了！！！");
        System.out.println("给钱给小弟弟，让他去买。");
        Son son = new Son();
        son.start();
        try {
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我接过烟抽了起来，并把零钱给了小弟弟!");

    }
}

class Son extends Thread {
    @Override
    public void run() {
        System.out.println("小弟弟接过钱去买烟。");
        System.out.println("发现路边有个游戏厅，玩了10秒");
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("过去了"+i+"秒");

        }
        System.out.println("想起要去买烟！！");
    }
}


