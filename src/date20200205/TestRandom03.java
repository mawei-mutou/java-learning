package date20200205;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/5
 * time        : 12:08
 * description :面向对象封装分割
 */
public class TestRandom03 {
    //源头
    private File src;
    //目的地
    private String destDir;
    //所以分割后的文件存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数
    private int size;

    //构造器
    public TestRandom03(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();

        //初始化
        init();
    }

    //初始化
    private void init() {
        //总长度
        long len = this.src.length();
        //分多少块
        this.size = (int) Math.ceil((len * 1.0 / blockSize));
        //路径
        for (int i = 0; i < size; i++) {
            this.destPaths.add(this.destDir + "/"+i + "-" + this.src.getName());
        }
    }

    /**
     * 分割
     * 1、计算每一块的起始位置及大小
     * 2、分割
     */
    public void split() throws IOException {
        long len = src.length();
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
            splitDetail(i, beginPos, actualSize);
        }
    }

    private void splitDetail ( int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        OutputStream raf2 = new FileOutputStream(this.destPaths.get(i));
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int length = -1;

        while ((length = raf.read(flush)) != -1) {
            if (actualSize > length) {
                raf2.write(flush, 0, length);
                actualSize -= length;
            } else {
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    //文件的合并
    public void merge(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));
        //输入流
        for (int i = 0; i < destPaths.size(); i++) {
            InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
            is.close();
        }
        os.close();
    }


    public static void main(String[] args) throws IOException {
        TestRandom03 sf = new TestRandom03("copy.jpg", "dest", 1024 * 10);
        sf.split();
        sf.merge("Copy234.jpg");
    }
}

