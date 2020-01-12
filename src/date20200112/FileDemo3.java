package date20200112;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 16:18
 * description :
 */
public class FileDemo3 {
    public static void main(String[] args) {
        File root = new File("C:\\Users\\MrYou\\Desktop\\画册");
        //File[] dirs = rout.listFiles();
//        System.out.println(dirs[0]);
        printName(root,0);
    }

    public static void printName(File path,int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println(path.getName());

        if (null == path || !(path.exists())) {

            return;
        } else if (path.isDirectory()) {
            for (File temp : path.listFiles()) {

                printName(temp, count + 1);

            }
        }
    }
}


