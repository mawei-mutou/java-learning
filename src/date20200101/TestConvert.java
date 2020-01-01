package date20200101;

/**
 * 测试类型转化
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 15:38
 * description :
 */
public class TestConvert {
    public static void main(String[] args) {
        int a = 324;
        long b = a;
        double d = b;
        //a = b这是错误的，因为long的范围比int大
        //long e = 3.14f;
        float f = 234324l;
        //特例；
        byte b2 = 123;
        double x = 3.14;
        int nx = (int)x;
        char c = 'a';
        int p = c + 1;
        System.out.println(nx);
        System.out.println(p);
        System.out.println((char) p);

    }
}
