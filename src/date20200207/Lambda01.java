package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 10:35
 * description :
 */
public class Lambda01 {
    static class Test1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new Test1()).start();
    }

}


