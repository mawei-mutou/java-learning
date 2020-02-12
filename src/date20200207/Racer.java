package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 9:31
 * description :
 */
public class Racer implements Runnable {
    private String winner;//胜利者

    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            if ((Thread.currentThread().getName().equals("兔子")) && (steps % 10 == 0)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().getName()+"-->" + steps);
            boolean flag = gameOver(steps);
            if (flag) {
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner-->" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "兔子").start();
        new Thread(racer, "乌龟").start();
    }
}
