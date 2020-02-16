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
public class LoginMultiClient {

    private static String uname;
    private static String upwd;
    private  static Socket client ;
    private static DataOutputStream dos;
    private static DataInputStream dis;
   private static BufferedReader console;

    private static void initial() throws IOException {
         console= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        uname = console.readLine();
        System.out.println("请输入密码：");
        upwd = console.readLine();
    }

    public static void main(String[] args) throws IOException {
        initial();
        send();
        receive();
        release();
    }

    private  static void  send() throws IOException {
            try {
                client= new Socket("localhost", 9998);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dos= new DataOutputStream(client.getOutputStream());
                dos.writeUTF("uname=" + uname + "&" + "upwd=" + upwd);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    private static void receive() {
        try {
            dis = new DataInputStream(client.getInputStream());
            String result = dis.readUTF();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void release() {
        try {
            if (dos != null) {
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }try {
            if (dis != null) {
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }try {
            if (console != null) {
                console.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
