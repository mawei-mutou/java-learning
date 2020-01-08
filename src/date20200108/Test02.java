package date20200108;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 15:14
 * description :
 */
public class Test02 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("C:/aa.txt");
            System.out.println("step1");
            char c1 = (char) reader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("step3");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
