package date20191231.package1;

import java.awt.*;
import java.io.File;
import javax.swing.*;

/**
 * created with IntelliJ IDEA
 * author      : yaodong
 * date        : 2019/12/31
 * time        : 13:54
 * description :
 */
public class ballgame extends JFrame {
    // 只有加上了 final static 才被认为是常量
    final static String NAME1="tomas";
    // 加上了final的修饰符 只能认为该值是不能重新被赋值的
    final String NAME2="tomas";

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
    double x = 100;//小球的横坐标
    double y = 100;//小球的纵坐标
    double degree = 3.14/3;//弧度。此处就是：60度
    //画窗口的方法
    public void paint(Graphics graphics) {
        int a=1;
        final int a1=2;
        final String vv = "kkk";
        System.out.println("窗口被画了一次");
        graphics.drawImage(desk, 0, 0, null);
        graphics.drawImage(ball, (int)x,(int)y, null);
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);
        if (y > 500 - 40 - 30 || y < 40+40) {
            final String vv22 = "kkk";
            degree = -degree;
            int a3=1;
            int cc= a+1;
        }
        //碰到左右边界
        if(x<40||x>856-40-30){
            degree = 3.14 - degree;
        }
    }

    /**
     * 加载框架
     * @param name 名字
     * @param age 年龄
     */
    /*
    asdasd
    asdasd
    asdasd
    asdasd
    asdasd
    asdasd
     */
    void launchFrame(String name, int age) {
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
//        game.launchFrame();
    }
}
