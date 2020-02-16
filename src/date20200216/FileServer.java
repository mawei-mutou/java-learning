package date20200216;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 15:04
 * description :
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9898);
        Socket client = server.accept();

        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("20200216.jpg"));
        byte[] datas = new byte[1024];
        int len = -1;
        while ((len = is.read(datas)) != -1) {
            os.write(datas, 0, len);
        }
        os.flush();
        is.close();
        client.close();
        server.close();

    }
}
