package date20200204;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 21:59
 * description :
 */
public class IOTest08 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println(123);
        ps.println(false);
        ps.println("媳妇");
        //打印文件去
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")), true);
        ps.println(123);
        ps.println(false);
        ps.println("媳妇");

        //重定向输出端
        System.setOut(ps);
        System.out.println("加油，武汉！");
        //ps.close();

        //重定向会控制台

        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))));
        System.out.println("我回来了");
    }
}

