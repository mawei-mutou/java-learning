package date20200202;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/2
 * time        : 12:27
 * description :
 */
public class TestMkdir2 {
    public static void main(String[] args) {
        File src = new File("C:/Users/MrYou/Desktop/java-learning");
        printName(src,0);
    }

    public static void printName(File src,int deep) {

        for (int i = 0; i <= deep; i++) {
            System.out.print("--");
        }
        System.out.println(src.getName());
        if (null == src || !src.exists()) {
            return;
        } else if (src.isDirectory()) {
            for (File s : src.listFiles()) {
                printName(s,deep+1);
            }
        }
    }
}
