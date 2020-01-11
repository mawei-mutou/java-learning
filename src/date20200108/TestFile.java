package date20200108;

import java.io.File;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 12:28
 * description :
 */
public class TestFile {
    public static void main(String[] args) {
        File f = new File("C:/abccc.txt");
        System.out.println(f);
        f.renameTo(new File("C:/bb.txt"));


        System.out.println(System.getProperty("user.dir"));

        File f2 = new File("gg.txt");

        System.out.println("File是否存在：" + f2.exists());
        System.out.println("File是否为目录：" + f2.isDirectory());
        System.out.println("File是否为文件：" + f2.isFile());
        System.out.println("File最后修改时间：" + new Date(f2.lastModified()));
        System.out.println("File的大小：" + f2.length());
        System.out.println("File的名字：" + f2.getName());
        System.out.println("File的目录路径：" + f2.getPath());
        System.out.println("File的绝对路径：" + f2.getAbsolutePath());

        File f3 = new File("c:/电影/华语/大陆");
        // 创建第一级
        boolean flag = f3.mkdir();
        // 批级创建
        boolean flag1 = f3.mkdirs();
        System.out.println(flag1);
    }
}
