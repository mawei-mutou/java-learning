package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 21:32
 * description :
 */
public class LambdaThread3 {
    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable(){
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("而是因为想你所以寂寞！");
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("不是因为寂寞才想你");
            }
        }).start();
    }
}
