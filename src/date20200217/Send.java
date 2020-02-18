package date20200217;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/17
 * time        : 11:58
 * description :
 */
public class Send implements Runnable {
    private boolean isRunning;
    private DataOutputStream dos;
    private String msg = "";
    private Initial initial;
    private  BufferedReader br;
    private String name;

    public Send(Initial initial,String name) {
        this.initial = initial;
        this.br = initial.getBr();
        this.dos = initial.getDos();
        this.isRunning = true;
        this.name = name;
        send(name);
    }

    public String receive() {
        try {
            msg = br.readLine();
        } catch (IOException e) {
            System.out.println("=======1=======");
            release();
        }
        return msg;
    }

    public boolean send(String msg) {
        boolean flag=false;
        try {
            dos.writeUTF(msg);
            dos.flush();
            isRunning=true;
            flag = true;
        } catch (IOException e) {
            System.out.println("==========2=========");
            release();
        }
        return flag;
    }

    public void release() {
        this.isRunning=false;
        Utils.close(dos, br);
    }

    @Override
    public void run() {
        //System.out.println("isRunning:"+isRunning);
        while (isRunning) {
            receive();
            //System.out.println("接受成功,msg为："+msg);
            if (!msg.equals("")) {
                if (send(msg)) {
                    //System.out.println("发送成功");
                }
            }
        }
    }
}
