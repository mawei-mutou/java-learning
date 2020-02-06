package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 16:32
 * description :
 */
public class Racer implements Runnable {
    private String winner;
   // private int steps;
    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
//            if (Thread.currentThread().getName().equals("兔子")) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(Thread.currentThread().getName()+"->"+steps);
            boolean flag = gameOver(steps);
            if (flag) {
                break;
            }
        }
    }

    public boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner->"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer rc = new Racer();
        new Thread(rc, "乌龟").start();
        new Thread(rc, "兔子").start();
    }

}

