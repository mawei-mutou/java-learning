package date20200114;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/14
 * time        : 15:50
 * description :
 */
public class IoTest03 {
    public static void main(String[] args) {
        byte[] datas = fileToByteArray("src/images/ball.png");
        System.out.println(datas.length);
        byteArrayToFile(datas, "p-byte.png");
    }

    /**
     * 1、图片读取到字节数组中
     * 1）、图片到程序 FileInputStream
     * 2）程序到字节数组ByteArrayOutputStream
     */
    public static byte[] fileToByteArray(String filePath) {
//1、创建源与目的地
        File src = new File(filePath);
        byte[] dest =null;

        //2、选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            //3、操作（分段读取）
            byte[] flush = new byte[1024 * 10];//缓冲器
            int len = -1;//接受长度
            while ((len = is.read(flush)) != -1) {
                baos.write(flush, 0, len);//写出到字节数组中
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 2、字节数组到图片
     * 1）、字节数组到程序ByteArrayInputStream
     * 2）、程序到图片文件FileOutputStream
     */
    public static void byteArrayToFile(byte[] src, String filePath) {
        //1、创建输入源，这里就是src
        File dest = new File(filePath);//输出目的地
        //2、选择流
        InputStream is =null;
        OutputStream os =null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            //3、操作
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
