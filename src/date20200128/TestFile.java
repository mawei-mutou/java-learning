package date20200128;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/28
 * time        : 17:43
 * description :
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\MrYou\\Desktop\\gg.txt");
        f.createNewFile();//创建文件
        System.out.println(f);
        f.renameTo(new File("C:\\Users\\MrYou\\Desktop\\dd.txt"));

        System.out.println(System.getProperty("user.dir"));
        File f2 = new File("ppp.txt");
        f2.createNewFile();

        System.out.println("文件是否存在：" + f2.exists());
        System.out.println("文件是否为目录：" + f2.isDirectory());
        System.out.println("文件是否为文件：" + f2.isFile());
        System.out.println("文件最后修改时间：" + new Date(f2.lastModified()));
        System.out.println("文件长度：" + f2.length());
        System.out.println("文件的文件名：" + f2.getName());
        System.out.println("文件路径为："+f2.getAbsolutePath());


        File f4 = new File("C:\\Users\\MrYou\\Desktop\\dd.txt");
        f4.delete();
    }
}
