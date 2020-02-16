package date20200216;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 14:25
 * description :
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        String name = "";
        String upwd = "";
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();
        System.out.println("一个客户端建立了链接");
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();

        String[] dataArrays = datas.split("&");

        for (String temp : dataArrays) {
            String[] uInfo = temp.split("=");
            if (uInfo[0].equals("uname")) {
                System.out.println("输入的名字为：" + uInfo[1]);
                name = uInfo[1];
            } else if (uInfo[0].equals("upwd")) {
                System.out.println("输入的密码为：" + uInfo[1]);
                upwd = uInfo[1];
            }
        }

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if (name.equals("yaodong") && upwd.equals("123456")) {
            dos.writeUTF("登录成功，欢迎回来！");
        } else {
            dos.writeUTF("登陆失败！");
        }

        dis.close();
        dos.close();
        client.close();
        server.close();
    }
}
