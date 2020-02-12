package date20200208;
/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 16:01
 * description :
 */
public class AllState {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 1; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("-------------");
            }
        });

        Thread.State state = t.getState();
        System.out.println(state);

        //新的一条线程
        t.start();
        state = t.getState();
        System.out.println(state);
        System.out.println(Thread.activeCount());

        //主线程的内容
        while (true) {
            int num = Thread.activeCount();
            System.out.println(num);
            if (num == 2) {
                break;
            }
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state =t.getState();//Time_Waiting
            System.out.println(state);

        }
    }
}
