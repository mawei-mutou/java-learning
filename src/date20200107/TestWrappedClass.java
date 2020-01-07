package date20200107;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 16:24
 * description :
 */
public class TestWrappedClass {
    public static void main(String[] args) {

        //基本数据类型转化为包装对象
        Integer a = new Integer(3);
        System.out.println(a);
        Integer b = Integer.valueOf(3);
        System.out.println(b);

        //包包装类对象转换成基本数据类型
        int c = a.intValue();
        System.out.println(c);
        double d =a.intValue();
        System.out.println(d);

        //吧字符串转变成包装类对象
        Integer e = new Integer("8888");
        System.out.println(e);
        int p = e.intValue();

        System.out.println(p);

        Integer f = Integer.valueOf("888");
        System.out.println(f);

        //将包装类对象转化为字符串
        String h = e.toString();
    }
}
