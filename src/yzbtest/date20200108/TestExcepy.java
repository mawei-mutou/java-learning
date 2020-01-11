package yzbtest.date20200108;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestExcepy {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(test1());
        try {
            new FileOutputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        new FileOutputStream("");
    }

    public static String test1(){
        try {
            System.out.println("runned try");
            // 手动抛出异常的方式
            throw new RuntimeException("这里报错啦!");
//            return "a";
        }catch (RuntimeException e){
            System.out.println("这里捕获啦");
            return "b";
        }finally {
            System.out.println("这里是finally");
            return "c";
        }
    }
}
