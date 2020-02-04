package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 19:06
 * description :文件字符输入输出流
 */
public class IOTest10 {
    public static void main(String[] args) {
        File src1 = new File("IO.txt");
        File src2 = new File("COPY2.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src1);
            writer = new FileWriter(src2);

            char[] datas = new char[1024];
            int len = -1;
            while ((len = reader.read(datas)) != -1) {
                System.out.println(datas);
                writer.write(datas, 0, datas.length);
                writer.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
