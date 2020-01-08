package date20200108;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**使用throws声明异常
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 16:26
 * description :
 */
public class Test03 {
        public static void main(String[] args) throws IOException {
            readMyFile();
        }


public static void readMyFile() throws IOException{
    FileReader reader = null;
    reader = new FileReader("C:/aa.txt");
    System.out.println("step1");
    char c1 = (char) reader.read();
    System.out.println(c1);

    if (reader != null) {
        reader.close();
             }
        }
}
