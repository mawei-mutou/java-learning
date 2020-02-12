package date20200208;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 10:53
 * description :
 */

public class BlockedSleep02 {

    private static String winner=null;
    public static boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner:" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Thread(()-> {
        for (int steps = 1; steps <= 100; steps++) {
                if (Thread.currentThread().getName().equals("兔子") && steps % 10 == 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName()+"-->"+steps);
                boolean flag = gameOver(steps);
                if (flag) {
                    break;
                }
            }
        }, "兔子").start();

        new Thread(()-> {
            for (int steps = 1; steps <= 100; steps++) {
                if (Thread.currentThread().getName().equals("兔子") && steps % 10 == 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName()+"-->"+steps);
                boolean flag = gameOver(steps);
                if (flag) {
                    break;
                }
            }
        }, "乌龟").start();
    }
}

//public class BlockedSleep02 implements Runnable {
//
//    private String winner=null;
//    public static void main(String[] args) {
//        BlockedSleep02 racer=new BlockedSleep02();
//        new Thread(racer, "兔子").start();
//        new Thread(racer, "乌龟").start();
//   }
//
//    @Override
//    public void run() {
//        for (int steps = 1; steps <= 100; steps++) {
//            if (Thread.currentThread().getName().equals("兔子") && steps % 10 == 0) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            System.out.println(Thread.currentThread().getName()+"-->"+steps);
//            boolean flag = gameOver(steps);
//            if (flag) {
//                break;
//            }
//        }
//    }
//
//    public boolean gameOver(int steps) {
//        if (winner != null) {
//            return true;
//        } else {
//            if (steps == 100) {
//                winner = Thread.currentThread().getName();
//                System.out.println("winner:" + winner);
//                return true;
//            }
//        }
//        return false;
//    }
//}
