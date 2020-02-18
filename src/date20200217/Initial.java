package date20200217;

import java.io.*;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/17
 * time        : 11:59
 * description :
 */
public class Initial {
    private String uname;
    private int port;
    private BufferedReader br = null;
    private DataInputStream dis= null;
    private DataOutputStream dos= null;
    private Socket client= null;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public DataInputStream getDis() {
        return dis;
    }

    public void setDis(DataInputStream dis) {
        this.dis = dis;
    }

    public DataOutputStream getDos() {
        return dos;
    }

    public void setDos(DataOutputStream dos) {
        this.dos = dos;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public Initial(String uname, int port) {
        System.out.println("-----client------");
        this.uname = uname;
        this.port = port;

        try {
            client = new Socket(uname, port);
            br = new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("初始化错误");
        }

    }
}
