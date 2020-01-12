package date20200112;

import java.io.File;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 14:44
 * description :
 */
public class FileDemo0 {
    public static void main(String[] args) {
        String path = "C:\\Users\\MrYou\\Desktop\\java-learning\\src\\images\\ball.png";

        String path2 = "C:/Users/MrYou/Desktop/画册/20201/";
        //创建File对象
        File src = new File(path);
        File src2 = new File(path2);
        System.out.println(src.length());
        System.out.println(src.getName());
        System.out.println(src.isDirectory());
        System.out.println(src.exists());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getPath());
        System.out.println(src.lastModified());
        Date a = new Date(src.lastModified());
        System.out.println(a);
        System.out.println(src.listFiles());

        System.out.println(src2.mkdir());
        System.out.println(src2.mkdirs());

        src = new File("C:\\Users\\MrYou\\Desktop\\java-learning\\src", "images\\ball.png");
        System.out.println(src);

        src = new File(new File("C:\\Users\\MrYou\\Desktop\\java-learning\\src"), "images\\ball.png");
        System.out.println(src.getPath());

        //相对路径
        System.out.println(System.getProperty("user.dir"));
        File src3 = new File("src/images/bg.jpg");
        System.out.println(src3.exists());

        File pp = src3.getParentFile();
        System.out.println(pp.getPath());
        System.out.println(pp.getAbsolutePath());
        System.out.println(pp.getName());

        File gg = new File("make/kj/nnj");
        System.out.println(gg.exists());
        gg.mkdir();
        System.out.println(gg.exists());
        gg.delete();
        System.out.println(gg.exists());
    }
}
