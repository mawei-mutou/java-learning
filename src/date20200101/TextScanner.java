package date20200101;
import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 16:29
 * description :
 */
public class TextScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name = scanner.nextLine();
        System.out.println("请输入你的爱好");
        String favor = scanner.nextLine();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        System.out.println("#########");
        System.out.println(name);
        System.out.println(favor);
        System.out.println("来到地球的天数：" + age * 365);
        System.out.println("离开地球的天数：" + (72 - age) * 365);
    }
}
