package date20200201;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/1
 * time        : 22:49
 * description :
 */
public class TestFile {
    public static void main(String[] args) {
        //构建File对象
        File src = new File("C:/Users/MrYou/Desktop/java-learning/copy.jpg");
        System.out.println(src.length());
        System.out.println(src.getName());

        src = new File("C:/Users/MrYou/Desktop/", "java-learning/copy.jpg");
        System.out.println(src.length());

        src = new File(new File("C:/Users/MrYou/Desktop/"), "java-learning/copy.jpg");
        System.out.println(src.length());


    }
}
