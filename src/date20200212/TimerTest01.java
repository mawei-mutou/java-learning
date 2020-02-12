package date20200212;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/12
 * time        : 19:20
 * description :
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 10000);
        timer.schedule(new MyTask(),15000,200);
    }
}

//任务类
class MyTask extends TimerTask {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("放空大脑休息一下");
        }
        System.out.println("-----------end----------------");
    }
}
