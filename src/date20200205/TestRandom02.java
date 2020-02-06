package date20200205;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/5
 * time        : 11:46
 * description :将文件分割到指定文件夹中存储
 */
public class TestRandom02 {
    public static void main(String[] args) {
        //分多少块
        File src = new File("C:/Users/MrYou/Desktop/java-learning/src/date20200204/IOTest07.java");
        //总长度
        long len = src.length();
        //每块多大
        int blockSize = 1026;
        //分多少块
        int size = (int) Math.ceil((len * 1.0 / blockSize));

        System.out.println(size);

        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i++) {

            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int) len;

            } else {
                actualSize = blockSize;
                len = len - blockSize;
            }
            System.out.println(i + "-->" + beginPos + "-->" + actualSize);
            try {
                split(i, beginPos, actualSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void split(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(
                new File("C:/Users/MrYou/Desktop/java-learning/src/date20200204/IOTest07.java"), "r");
        OutputStream raf2 = new FileOutputStream(
                new File("C:/Users/MrYou/Desktop/java-learning/dest/" + i +"-"+ "Copy.java")) {
        };
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;

        while ((len = raf.read(flush)) != -1) {
            if (actualSize > len) {
                raf2.write(flush,0,len);
                actualSize -= len;
            } else {
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }
}
