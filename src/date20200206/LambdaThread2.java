package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 21:30
 * description :
 */
public class LambdaThread2 {
    public static void main(String[] args) {
        class Test implements Runnable {
            @Override
            public void run() {
                for(int i=0;i<20;i++){
                    System.out.println("一边学习");
                }
            }
        }
        new Thread(new Test()).start();
    }
}
