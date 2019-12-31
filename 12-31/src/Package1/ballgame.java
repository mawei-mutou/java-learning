package Package1;
import java.awt.*;
import javax.swing.*;

/**
 * created with IntelliJ IDEA
 * author      : yaodong
 * date        : 2019/12/31
 * time        : 13:54
 * description :
 */
public class ballgame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("~/Desktop/小白球.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage("/Users/huxiaoyang/Desktop/球桌.jpg");
    double x = 100;//小球的横坐标
    double y = 100;//小球的纵坐标
    double degree = 3.14/3;//弧度。此处就是：60度
    //画窗口的方法
    public void paint(Graphics graphics) {
        System.out.println("窗口被画了一次");
        graphics.drawImage(desk, 0, 0, null);
        graphics.drawImage(ball, (int)x,(int)y, null);
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);
        if (y > 500 - 40 - 30 || y < 40+40) {
            degree = -degree;
        }
        //碰到左右边界
        if(x<40||x>856-40-30){
            degree = 3.14 - degree;
        }
    }
    //窗口加载
    void launchFrame() {
        setSize(1000, 1000);//窗口尺寸为300，300
        setLocation(50, 50);//以窗口左上角为坐标原点，y向下，x向左，目标窗帘左上角距离原点各为50。
        setVisible(true);
        //重画窗口
        while (true) {
            repaint();
            try {

                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //main方法是程序执行的入口
    public static void main(String[] args) {
        System.out.println("游戏小项目");
        ballgame game = new ballgame();
        game.launchFrame();
    }
}
