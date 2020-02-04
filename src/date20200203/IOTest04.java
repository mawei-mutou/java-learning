package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 15:12
 * description :
 */
public class IOTest04 {
    public static void main(String[] args) {
        //读取文件内容
        File src1 = new File("IO.txt");//源头
        File src2 = new File("dest.txt");//目的地

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src1);
            os = new FileOutputStream(src2);
            byte[] input = new byte[1024];
            int len = -1;
            while ((len = is.read(input)) != -1) {
                String str = new String(input);
                System.out.println(str);
                os.write(input, 0, input.length);
                os.flush();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
