package date20200215;

import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 16:46
 * description :
 */
public class TalkHe {
    public static void main(String[] args) throws SocketException {
        new Thread(new TalkReceive(9985,"木头")).start();
        new Thread(new TalkSend(7596,6983,"localhost")).start();//发送
    }
}
