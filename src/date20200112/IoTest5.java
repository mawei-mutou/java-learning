package date20200112;

import java.io.*;

/**五遍
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 20:50
 * description :
 */
public class IoTest5 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("dest.txt");//文件可以不存在，自动创建
        //2、选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(src,true);//true则每次在后面追加，false则每次重写
            //3、写出
            String msg = "IO is so easy";
            byte[] datas = msg.getBytes();//字符串到字节数组
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //4、释放资源
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
