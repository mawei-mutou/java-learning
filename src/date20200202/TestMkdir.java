package date20200202;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/2
 * time        : 10:28
 * description :
 */
public class TestMkdir {
    public static void main(String[] args) {
        File src = new File("C:/Users/MrYou/Desktop/美女");
        boolean temp = src.mkdir();
        System.out.println(temp);
        boolean temp2 = src.mkdirs();
        System.out.println(temp2);

        src.delete();
        System.out.println(src.exists());
        System.out.println("——————————————————————————————————分割线————————————————————————————————————————————————————");

        //列出下一级目录
        String str = System.getProperty("user.dir");
        System.out.println(str);

        src = new File("C:/Users/MrYou/Desktop/java-learning");
        String[] sub = src.list();

        str = "C:/Users/MrYou/Desktop/java-learning";

        for (String temps : sub) {
            System.out.println(temps);
        }
        System.out.println("——————————————————————————————————分割线————————————————————————————————————————————————————");

        //获取目录下的所有文件名
    }



}
