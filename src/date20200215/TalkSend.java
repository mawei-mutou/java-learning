package date20200215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 16:33
 * description :
 */
public class TalkSend implements Runnable {
    private DatagramSocket send ;
    private BufferedReader read ;
    private int toPort;
    private String toIP;


    public TalkSend(int port,int toPort,String toIP) {
        this.toPort = toPort;
        this.toIP = toIP;
        try {
            send = new DatagramSocket(port);
            read = new BufferedReader(new InputStreamReader(System.in));

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            String st;
            try {
                st = read.readLine();
                byte[] datas = st.getBytes();
                //3、封装成DatagramPacket 包裹 ，需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(this.toIP, this.toPort));
                send.send(packet);
                if (st.equals("bye")) {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            //4、发送包裹send(DatagramPacket p)
            //  byte[] getData();
            //getLength()

        }
        // 5、释放资源
        send.close();
    }
}
