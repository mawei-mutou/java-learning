package date20200210;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/10
 * time        : 9:38
 * description :
 */
public class Safe2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{

                synchronized (list){list.add(Thread.currentThread().getName());}
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(list.size());
    }
}
