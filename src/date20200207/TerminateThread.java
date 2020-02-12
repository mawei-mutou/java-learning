package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 11:21
 * description :
 */
public class TerminateThread implements Runnable {
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("C罗");
        new Thread(tt).start();

        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                tt.terminate();
                System.out.println("tt game over!");

            }
            System.out.println("main-->"+i);
        }
    }

    @Override
    public void run() {
        int i=0;
        while (flag) {
            System.out.println(name+"-->"+i++);
        }
    }

    //3、对外提供方法改变标识
    public void terminate() {
        this.flag = false;
    }
}