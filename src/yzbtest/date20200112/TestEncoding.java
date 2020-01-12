package yzbtest.date20200112;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestEncoding {
    /**
     * 关于UTF-8编码模式的有bom和无bom
     * bom 是一个文件头 在windows系统中的文件，在每个文件的头部需要一个文件头来标识该文件的编码格式，()。所以说bom是windows系统独有的文件特征
     * bom是一个十六进制的一串字符。
     * ANSI=GB2312，此外还有一种在国内windows系统中默认的编码格式是GBK，GBK包含GB2312
     * @param args
     */
    public static void main(String[] args) {
        // RuntimeException子类，不需要显式的捕获。
        Integer in1 = Integer.parseInt("aaaaa");
        try {
            new FileInputStream("filePath");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
