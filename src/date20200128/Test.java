package date20200128;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/28
 * time        : 18:07
 * description :
 */
public class Test {
    public static void main(String[] args) {
        File f = new File("C:\\Program Files\\Git");
        System.out.println("是否为目录：" + f.isDirectory());

        printFile(f,0);
      }

    static void printFile(File file,int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("_");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                printFile(temp,count+1);

            }
        }
    }
}
