package date20200105.PlayGame05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import static date20200105.PlayGame05.Constant.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/4
 * time        : 16:43
 * description :
 */
public class MyGameFrame extends Frame {


    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");

    Plane plane = new Plane(planeImg,250,250);
    Shell[] shells = new Shell[50];
    Explode bao;
    Date startTime = new Date();
    Date endTime;
    int period;//游戏持续时间
    @Override
    public void paint(Graphics g) {
        Color c =g.getColor();
        g.drawImage(bg, 0, 0, null);

        //画飞机
        plane.drawSelf(g);

        for (int i = 0; i < shells.length; i++) {
            shells[i].draw(g);

            //飞机的简单碰撞检测
            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if (peng) {
                plane.live =false;

                if (bao == null) {
                    bao = new Explode(plane.x, plane.y);
                    endTime = new Date();
                    period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
                }
                bao.draw(g);
            }
            //计时提示
            if (!plane.live) {
                g.setColor((Color.red));
                Font f = new Font("宋体", Font.BOLD, 40);
                g.setFont(f);
                g.drawString("时间："+period+"秒",(int)plane.x,(int)plane.y);
            }

        }

        g.setColor(c);
    }

    private Image offScreenImage = null;

//双缓冲代码
    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
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
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }


    //初始化窗口
    public void launchFrame() {
        this.setTitle("姚小二作品");
        this.setVisible(true);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(300, 300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);

            }
        });

        //启动重画线程
        new PaintThread().start();

        //给窗口增加键盘的监听
        addKeyListener(new KeyMonitor());

        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }
    }


    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
