package date20200216;

import java.io.*;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 15:04
 * description :
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9898);
        InputStream is = new BufferedInputStream(new FileInputStream("timg.jpg"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());

        byte[] datas = new byte[1024];
        int len = -1;
        while ((len = is.read(datas)) != -1) {
            os.write(datas, 0, len);
        }
        os.flush();

        os.close();
        is.close();
        client.close();
    }
}
