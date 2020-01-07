package date20200107;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 16:52
 * description :
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 124;//自动装箱

        int b = a;//自动拆箱

        //Integer.valueOf(127);
        Integer c = 128;//Integer c = Integer.valueOf(128)
        Integer d = 128;
        System.out.println(c == d);
        System.out.println(c.equals(d));

        Integer f = -58;
        Integer g = -58;
        System.out.println(f == g);
    }
}



