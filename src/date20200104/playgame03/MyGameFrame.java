package date20200104.playgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");

    Plane plane = new Plane(planeImg,250,250);

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);

        plane.drawSelf(g);//画飞机


    }

    //内部类线程,帮助我们反复重画窗口
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                //System.out.println("窗口被重画一次！");
                repaint();//重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //定义键盘监听的内部类
    class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下"+e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("抬起："+e.getKeyCode());

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
        addKeyListener(new KeyMonitor());//给窗口增加键盘的监听

    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
