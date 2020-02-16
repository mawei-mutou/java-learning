package date20200215;

import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 16:46
 * description :
 */
public class TalkMe {
    public static void main(String[] args) throws SocketException {
        new Thread(new TalkSend(8989,9985,"localhost")).start();//发送
        new Thread(new TalkReceive(6983, "马尾")).start();

    }
}
