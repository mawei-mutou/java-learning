package date20200218;

import java.lang.reflect.InvocationTargetException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/18
 * time        : 11:30
 * description :反射：把Java类中的各种结构（方法、属性、构造器、类名）映射为一个个的Java对象
 * 1、获取Class对象
 *      三种方法：Class.forName("完整路径")-->推荐使用这种方法
 * 2、可以动态创建对象
 */
public class Chapter1101Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //1、一种方式
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();

        //2、类.class()
        clz = Iphone.class;

        //3、Class.forName("包名.类名")
        //clz = Class.forName("date20200218.Iphone");
        Class c1 = Class.forName("date20200218.Iphone");

        //创建对象
        Iphone iphone2 = (Iphone) c1.getConstructor().newInstance();

        c1.getField("name");
        c1.getMethod("name");
        //Iphone iphone3=(Iphone)c1.get
//        Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();
//        System.out.println(iphone2);
    }
}

class Iphone {
    public Iphone() {
    }
}
