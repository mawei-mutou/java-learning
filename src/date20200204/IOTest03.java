package date20200204;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 15:53
 * description :
 */
public class IOTest03 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String msg = "";
            while (!(msg.equals("exit"))) {
                msg=reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
