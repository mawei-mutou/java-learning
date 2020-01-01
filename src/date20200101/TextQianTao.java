package date20200101;

/**
 * 测试嵌套循环
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 18:35
 * description :
 */
public class TextQianTao {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        for (int h = 1; h <= 9; h++) {
            for (int n = 1; n <= h; n++) {
                System.out.print(n+"*"+h+"="+n*h+"\t");

            }
            System.out.println();
        }
        System.out.println("#######################");
        int m = 100;
        int sum_1 = 0;
        int sum_2 = 0;
        while (m >= 0) {
            if (m % 2 == 0) {
                sum_2 += m;
            } else {
                sum_1 += m;
            }
            m--;
        }
        System.out.println("奇数的和：" + sum_1);
        System.out.println("偶数的和： " + sum_2);

        System.out.println("############");
        int p = 1;
        int count = 0;
        while (p <= 1000) {
            if (p % 5 == 0) {
                System.out.print(p+"\t");
                count++;
                if (count % 5 == 0) {
                    System.out.println();
                }
            }

            p++;
        }
    }
}
