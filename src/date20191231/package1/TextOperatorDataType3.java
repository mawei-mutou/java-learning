package date20191231.package1;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/12/31
 * time        : 20:09
 * description :
 */
public class TextOperatorDataType3 {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 & b2);//用&则b1和b2都会计算
        System.out.println(b1 | b2);
        System.out.println(b1 ^ b2);
        System.out.println(!b2);
        //短路
        boolean b3 = 1>2&&2<(3/0);//短路与，第一个操作数的值为false，则不需要计算后面的操作数
        System.out.println(b3);
        int a = 3;
        int b = 4;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a^b);
        System.out.println(~a);
        //移位
        int c = 3 << 2;
        System.out.println(c);
        System.out.println(12 >> 1);
    }
}
