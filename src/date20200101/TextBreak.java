package date20200101;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 20:06
 * description :
 */
public class TextBreak {
    public static void main(String[] args) {
        //打印100-150的不能被3整除的整数
        int count = 0;
        for (int i = 100; i < 150; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print((i + "、"));
            count++;
            if (count % 5 == 0) {
                System.out.println();
                count = 0;
            }
        }
        int count2 = 0;
        outer:for (int i = 100; i < 150; i++) {
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    continue outer;//跳到outer处
                }
            }
            System.out.print(i+" ");
        }
    }
}
