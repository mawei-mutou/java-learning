package date20200102;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 15:17
 * description :
 */

class Point{
    double x, y;

    //构造方法名称和类名必须一致
    public Point(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public double getDistance(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

}

public class TestConstructor {
    public static void main(String[] args) {
        Point p = new Point(3.0, 4.0);
        Point origin = new Point(0.0, 0.0);

        System.out.println(p.getDistance(origin));//这里不是明白

    }

}
