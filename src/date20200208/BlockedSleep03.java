package date20200208;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 11:48
 * description :
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(100);
            endTime = new Date(endTime.getTime() - 1000);
            if (end - 1000*10 > endTime.getTime()) {
                break;
            }

        }

    }
}
