package date20200104.playgame01;

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

    Image ball = GameUtil.getImage("images/ball.png");
    @Override
    public void paint(Graphics g) {
        Color  c = g.getColor();

        Font f = g.getFont();
        g.setColor(Color.green);

        g.drawLine(100,100,200,200);
        g.drawRect(100, 100, 300, 300);
        g.setColor(Color.red);
        g.setFont(new Font("宋体", Font.BOLD, 50));
        g.drawOval(100, 100, 300, 300);
        g.fillRect(100,100,40,40);
       // g.drawString("kkkk",200,200);//这里有问题

        g.drawImage(ball,250,250,null);
        g.setFont(f);
        g.setColor(c);
    }
    //初始化窗口
    public void launchFrame() {
        this.setTitle("姚小二作品");
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setLocation(100, 100);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);

            }
        });
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
