package date20200203;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 16:25
 * description :
 */
public class IOTest06 {
    public static void main(String[] args) {
        File dest = new File("IO.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(dest, true);
            String str = "我爱你，大宝贝！hxy";
            char[] datas = str.toCharArray();
            writer.write(datas);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
