package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 13:57
 * description :创建多线程方式二
 * 1、创建子类实现runnable，重写run方法
 * 2、创建实现类对象和代理对象，开启线程
 */
public class StartRun implements Runnable {
    //线程入口点
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
       // StartRun sr = new StartRun();
        new Thread(new StartRun()).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }
    }

}

