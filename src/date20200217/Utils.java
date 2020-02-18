package date20200217;

import java.io.Closeable;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/17
 * time        : 11:43
 * description :
 */
public  class Utils {
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            if (null != target) {
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
