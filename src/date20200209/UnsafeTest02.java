package date20200209;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
    }
}
