package date20200201;

import java.io.File;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 23:09
 * description :
 */
public class TestFile02 {
    public static void main(String[] args) throws IOException {
        File src = new File("C:/Users/MrYou/Desktop/java-learning/dd.txt");
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.exists());
        System.out.println(src.isDirectory());
        File src2 = new File("sfj.txt");
        System.out.println("src2是否存在：" + src2.exists());
        src2.createNewFile();
        System.out.println("src2是否存在：" + src2.exists());
        src2.delete();
        System.out.println("src2是否存在：" + src2.exists());

    }
}
                                   