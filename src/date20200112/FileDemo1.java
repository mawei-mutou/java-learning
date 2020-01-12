package date20200112;

import java.io.File;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 16:04
 * description :
 */
public class FileDemo1 {
    public static void main(String[] args) {
        File file1 = new File("src/date20200112/gg.txt");
        if (!file1.exists()) {
            System.out.println(file1.getName() + "不存在，新创建");
            try {
               file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(file1.delete());
    }
}
