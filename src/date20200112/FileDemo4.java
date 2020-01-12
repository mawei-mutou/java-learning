package date20200112;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 17:42
 * description :
 */
public class FileDemo4 {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        File file = new File(path);
        System.out.println(file.getPath());
        count(file);
        System.out.println(len);
    }

    private static long len =0;

    public static void count(File src) {
        if (null != src && src.exists()) {
           if(src.isFile()){
            len += src.length();
         //   System.out.println(src.getName());
            } else {
                for (File s : src.listFiles()) {
                    count(s);
                }
            }
        }
    }
}
