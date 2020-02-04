package date20200203;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/3
 * time        : 20:55
 * description :
 */
public class IOTest13 {
    public static void main(String[] args) {
        byte[] temp = A.toByteArray("src/images/ball.png");
        A.toFile(temp);
    }
}

class A {
    public static byte[] toByteArray(String str) {
        File src = new File(str);
        byte[] data = null;
        InputStream is = null;
        ByteArrayOutputStream bao = null;
        try {
            is = new FileInputStream(src);
            bao = new ByteArrayOutputStream();
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                bao.write(flush, 0, len);
                bao.flush();
            }

            data = bao.toByteArray();
            System.out.println("图片大小为："+data.length);

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
        }
        return data;
    }

    public static void toFile(byte[] p) {
        //字节数组-->程序、
        File src = new File("pictureCopy.png");
        InputStream is = null;
        //OutputStream os = null;
        try (OutputStream os =new FileOutputStream(src)){
            is = new ByteArrayInputStream(p);
           // os = new FileOutputStream(src);
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
