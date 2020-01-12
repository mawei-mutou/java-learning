package date20200112;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 21:58
 * description :
 */
public class IoTest8 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("wordoutput.txt");//文件可以不存在，自动创建
        //2、选择流
        FileWriter writer = null;
        try {
            writer = new FileWriter(src);//true则每次在后面追加，false则每次重写
            //3、写出
            String msg = "天蓝蓝，秋草香";
            char[] datas = msg.toCharArray();//字符串到字节数组
            writer.write(datas,0,datas.length);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //4、释放资源
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
