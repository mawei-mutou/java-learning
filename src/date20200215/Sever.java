package date20200215;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 21:26
 * description :
 */
public class Sever {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket receive = server.accept();

        DataInputStream dis = new DataInputStream(receive.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);

        dis.close();
        receive.close();
    }
}
