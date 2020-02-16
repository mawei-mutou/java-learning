package date20200215;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 16:43
 * description :
 */
public class TalkReceive implements Runnable {
    private DatagramSocket receive ;
    private String from;

    public TalkReceive(int port,String from) throws SocketException {
        this.from = from;
        receive = new DatagramSocket(port);

    }

    @Override
    public void run() {
        while (true) {
            //2、准备容器 封装成DatagramPacket 包裹
            byte[] datas = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);

            // 3、阻塞式接受包裹receive（DatagramPacket p）
            try {
                receive.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 4、分析数byte[] getData();
            // getLength()
            byte[] temp = packet.getData();
            int len = packet.getLength();
            String st = new String(temp, 0, temp.length);
            System.out.println(from+"说："+st);

            if (st.equals("bye")) {
                break;
            }
        }
        //5、释放资源
        receive.close();
    }
}
