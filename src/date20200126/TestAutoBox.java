package date20200126;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 10:43
 * description :
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 4;//自动装箱
        int b =a;//自动拆箱

        Integer c =null;
        if (c != null) {
            int d =c;
        }//会自动调用d=c.intValue()
        //包装类会缓存【-128，127】
        Integer in1 = Integer.valueOf("-128");
        Integer in2 = -128;
        System.out.println(in1==in2);

        Integer in3 = Integer.valueOf(23);
        Integer in4 = 23;
        System.out.println(in3==in4);
        System.out.println("###################");

        Integer in5 = 128;
        Integer in6 = 128;
        System.out.println(in5 == in6);
        System.out.println(in5.equals(in6));
    }




}
