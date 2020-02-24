package date20200224;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/24
 * time        : 20:20
 * description :
 */
public class EncrptUtil {
    public static void main(String[] args) throws IOException {
        encrpt("C:/Users/MrYou/Desktop/新建文件夹/HelloWorld.class", "C:/Users/MrYou/Desktop/新建文件夹/temp/HelloWorld.class");
    }

    public static void encrpt(String src, String dest) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int temp = -1;
            while ((temp = fis.read()) != -1) {
                fos.write(temp ^ 0xff);//对temp字节码取反
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                fos.close();
            }
            if (fis != null) {
                fis.close();

            }
        }
    }
}
