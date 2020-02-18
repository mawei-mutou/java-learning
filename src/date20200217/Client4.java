package date20200217;

import java.io.*;
import java.net.Socket;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 19:08
 * description :在线聊天室：客户端
 * 实现多个客户可以收发多条消息
 *  * 问题：其他客户必须等待之前的客户退出，才能继续，排队
 *  加入多线程，不必排队
 *
 */


public class Client4 {
    public static void main(String[] args) throws IOException {
        System.out.print("请输入用户名：");
        BufferedReader brs = new BufferedReader(new InputStreamReader(System.in));
        String name = brs.readLine();
        Initial initial = new Initial("localhost", 8268);
        new Thread(new Send(initial,name)).start();
        new Thread(new Receive(initial)).start();

 //       boolean isRunning =true;
//  //      while (isRunning) {
//            //2、客户端发送消息
////            String msg = "";
////            msg = initial.getBr().readLine();
////            new Send(initial.getDos()).send(msg);
//
//            //3、获取消息
//            Receive receive = new Receive(initial.getDis());
//            msg = receive.receive();
//            System.out.println(msg);
//        }
//        Utils.close(initial.getBr(),initial.getDis(),initial.getDos(),initial.getClient());
    }
}
