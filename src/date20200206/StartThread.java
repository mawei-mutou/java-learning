package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 13:57
 * description :创建多线程方式一
 * 1、创建子类继承Thread，重写run方法
 * 2、创建子类对象，开启线程
 */
public class StartThread extends Thread {
    //线程入口点
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        StartThread sf = new StartThread();
        sf.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }
    }

}

