package date20200112;

import java.io.*;

/**文件拷贝
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/12
 * time        : 21:12
 * description :
 */
public class IoTest6 {
    public static void main(String[] args) {
        //创建源
         File file = new File("src/images/bg.jpg");//源头
        File src = new File("copy.jpg");//文件可以不存在，自动创建，源尾

        //选择流
        InputStream is = null;
        OutputStream os = null;

        {
            try {
                is = new FileInputStream(file);
                os = new FileOutputStream(src,true);//true则每次在后面追加，false则每次重写

                //3、分段读取
                byte[] flush = new byte[5];
                int len =-1;
                while ((len = is.read(flush)) != -1) {
                    //字节数组到字符串
                    os.write(flush,0,len);

                }
                os.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {//先打开后关闭

                if (null != os) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
