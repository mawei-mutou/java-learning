package date20200215;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 21:26
 * description :
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、建立连接，使用Socket创建客户端+服务的地址和端口
        Socket socket = new Socket("localhost", 8888);
        //2、操作：输入输出流操作
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        String data = br.readLine();
        dos.writeUTF(data);
        dos.flush();
        //3、释放资源

        dos.close();
        socket.close();
    }
}
