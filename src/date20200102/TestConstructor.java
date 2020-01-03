package date20200102;

import date20200101.TestMethod;

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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getDistance(Point p) {
        System.out.println("this: "+ this.toString());
        System.out.println("p: "+ p.toString());
        p.x=10;
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
//        return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
    }

    public double getDistance(double x, double y) {
        x=20;
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
//        return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
    }

}

public class TestConstructor {
    public static void main(String[] args) {
        Point from = new Point(3.0, 4.0);
        Point origin = new Point(0.0, 0.0);
        Point origin2 = new Point(0.5, 0.8);

//        System.out.println(new TestMethod());
        // 引用传递
        System.out.println(from.getDistance(origin2));//这里不是明白
        System.out.println("origin2.x: "+origin2.x);
        // 值传递
        System.out.println(from.getDistance(origin2.x, origin2.y));//这里不是明白
        System.out.println("origin2.x: "+origin2.x);

    }

}
