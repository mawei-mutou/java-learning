package date20200206;

import org.apache.commons.io.FileUtils;
import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 14:26
 * description :
 */
public class WebDownloader {
    public void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
