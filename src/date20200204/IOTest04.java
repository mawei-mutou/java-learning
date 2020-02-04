package date20200204;

import java.io.*;
import java.net.URL;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 20:36
 * description :
 */
public class IOTest04 {
        public static void main(String[] args) {
            try (BufferedReader is =
                         new BufferedReader(
                                 new InputStreamReader(
                                         new URL("http://www.baidu.com").openStream(), "UTF-8"));
                 BufferedWriter writer =
                         new BufferedWriter(
                                 new OutputStreamWriter(
                                         new FileOutputStream("baidu.html")));) {

                String str;
                while ((str = is.readLine()) != null) {
                    //System.out.println(str);
                    writer.write(str);
                    writer.newLine();
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    class IOTests04 {
        public static void main(String[] args) {
            InputStreamReader is=null;
            try {
                is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8");
                int temp = -1;
                while ((temp = is.read()) != -1) {
                    System.out.print((char) temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
