package date20200126;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 10:35
 * description :
 */
public class TestWrapperClass {
    public static void main(String[] args) {
        Integer a = new Integer(10);
        System.out.println(a);
        Integer b = Integer.valueOf(9);
        System.out.println(b);

        int c = b.intValue();
        double d = b.doubleValue();

        Integer f = new Integer("999");
        Integer g = Integer.parseInt("58403");

        String str = g.toString();
        System.out.println(str);
    }
}
