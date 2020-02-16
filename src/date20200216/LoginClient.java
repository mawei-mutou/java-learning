package date20200216;

import java.io.*;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 14:25
 * description :
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String uname = console.readLine();
        System.out.println("请输入密码：");
        String upwd = console.readLine();

        Socket client = new Socket("localhost", 9999);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname=" + uname + "&" + "upwd=" + upwd);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String result = dis.readUTF();
        System.out.println(result);
        dos.close();
        client.close();
        console.close();
    }
}
