package date20200112;

import java.io.*;

/**这个10遍还差8遍
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 20:23
 * description :
 */
public class IoTest3 {
    public static void main(String[] args) {
        //创建源
        File file = new File("C:\\Users\\MrYou\\Desktop\\abc.txt");
        //选择流
        InputStream is = null;

        {
            try {
                is = new FileInputStream(file);
                int temp;
                while ((temp = is.read()) != -1) {
                    System.out.println((char) temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
