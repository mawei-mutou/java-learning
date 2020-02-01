package date20200129;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/29
 * time        : 20:06
 * description :
 */
public class TestException2 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("C:\\Users\\MrYou\\Desktop\\gg.txt");

            for (int i = 0; i < 3; i++) {
                char a = (char)reader.read();
                System.out.print(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
