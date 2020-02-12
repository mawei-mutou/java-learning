package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 10:42
 * description :
 */
public class Lambda2 {
    public static void main(String[] args) {

        new Thread(() ->{
            {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        }).start();
    }
}
