package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 20:29
 * description :
 */
public class Point {
    double x, y;

    //构造方法
//    public Point(double _x, double _y) {
//        x=_x;
//        y = _y;
//    }


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        Point origin = new Point(0, 0);
        System.out.println(p.getDistance(origin));

    }
}
