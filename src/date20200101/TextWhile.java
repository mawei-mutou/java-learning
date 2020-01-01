package date20200101;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 18:13
 * description :
 */
public class TextWhile {
    public static void main(String[] args) {
        //计算1+2+3+....+100的累计的和，5050
        //暴力
        int i = 0;
        int sum = 0;
        while (i <= 100) {
            sum = sum + i;
            i++;
        }
        System.out.println(sum);
    }
}
