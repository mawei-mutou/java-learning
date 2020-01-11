package yzbtest.date20200108;

import java.io.*;

public class TestFile {

    public static void main(String[] args) throws Exception {
        // D:\data\project\java-learning\src\yzbtest\date20200108
        File file = new File("D:\\data\\project\\java-learning\\src\\yzbtest\\date20200108\\test1\\test2\\t1.txt");
//        Writer writer =new OutputStreamWriter(new FileOutputStream(file));
//        writer.append("");
//        writer.flush();
//        writer.close();

        File file2 = new File("D:\\data\\project\\java-learning\\src\\yzbtest\\date20200108\\test1\\test2");
//        if(!file2.exists()){
//            file2.mkdir();
//        }
//        System.out.println(file2.exists());

        if(!file2.exists()){
            file2.mkdirs();
        }
        System.out.println(file2.exists());

    }
}
