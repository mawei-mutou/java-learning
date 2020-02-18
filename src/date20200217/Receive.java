package date20200217;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/17
 * time        : 11:58
 * description :
 */
public class Receive implements Runnable {
    private boolean isRunning;
    private DataInputStream dis;
    private String msg = "";
    private Initial initial;

   // private BufferedReader br;

    public Receive(Initial initial) {
        this.initial = initial;
        //this.br = initial.getBr();
        this.dis = initial.getDis();
        isRunning = true;
    }

    public String receive() {
        try {
            msg = dis.readUTF();
            isRunning = true;
        } catch (IOException e) {
            System.out.println("接受错误");
            release();
        }
        return msg;
    }

    public void release() {
        isRunning = false;
        Utils.close(dis);
    }
    @Override
    public void run() {
        while (isRunning) {
            String msg = receive();
            if (!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }
}
