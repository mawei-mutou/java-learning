package date20200104.playgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/4
 * time        : 16:43
 * description :
 */
public class MyGameFrame extends JFrame {

    Image plan = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");

    int Planx =250, Plany =250;
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);

        g.drawImage(plan, Planx, Plany, null);
        Planx++;
    }

    //内部类线程,帮助我们反复重画窗口
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("窗口被重画一次！");
                repaint();//重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //初始化窗口
    public void launchFrame() {
        this.setTitle("姚小二作品");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(300, 300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);

            }
        });

        //启动重画线程
        new PaintThread().start();
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
