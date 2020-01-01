package date20200101;

/**
 * 测试if-else
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 17:24
 * description :
 */
public class TextIfElse {
    public static void main(String[] args) {
        int h = (int) (6 * Math.random() + 1);
        System.out.println(h);
        if (h <= 3) {
            System.out.println("小");
        } else {
            System.out.println("大");
        }

        System.out.println("###########");
        //随机产生一个[0.0,4.0]之间的一个半径，并根据它来计算面积和周长
        double r = 4 * Math.random();
        //Math.pow(r,2)计算r的平方
        double area = Math.PI * Math.pow(r, 2);
        double circle = 2 * Math.PI * r;
        System.out.println("半径为： " + r);
        System.out.println("面积为： " + area);
        System.out.println("周长为： " + circle);
        //如果面积大于周长则输出面积大于周长，否则输出周长大于面积
        if (area > circle) {
            System.out.println("面积大于周长");
        } else {
            System.out.println("周长大于面积");

        }
    }
}
