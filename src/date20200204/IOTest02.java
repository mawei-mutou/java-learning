package date20200204;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 13:49
 * description :纯文本的复制，加缓冲流
 */
public class IOTest02 {
    public static void main(String[] args) {
        File src = new File("IO.txt");
        File dest = new File("IOCopy2.txt");
        try(BufferedReader reader=new BufferedReader(new FileReader(src));
            BufferedWriter writer=new BufferedWriter(new FileWriter(dest))) {
//            char[] flush = new char[1024];
//            int len = -1;
            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
