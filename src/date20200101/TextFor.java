package date20200101;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 18:21
 * description :
 */
public class TextFor {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

        for (int j = 1, h = j + 10; j <= 5; j++, h *= 2) {
            System.out.println("j =" + j + " h =" + h);
        }
        for (; ; ) {
            System.out.println("爱你到永远");

        }
    }

}
