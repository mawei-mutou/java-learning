package date20200221;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 15:53
 * description :
 */
public class Reflection02 {
    private static Class cls;
    public static void main(String[] args) {
        try {
            cls = Class.forName("date20200221.User");
            System.out.println(cls);
            //得到方法
            Method[] methods = cls.getDeclaredMethods();
            for (Method temp : methods) {
                System.out.println("方法："+temp);
            }
            Method method = cls.getDeclaredMethod("getName", null);
            System.out.println(method);
            //得到属性

            Field[] fields = cls.getDeclaredFields();
            for (Field temp : fields) {
                System.out.println("属性："+temp);
            }

            Field field = cls.getDeclaredField("name");
            System.out.println(field);
            //得到构造器

            Constructor[] constructors = cls.getConstructors();
            for (Constructor temp : constructors) {
                System.out.println("构造器："+temp);
            }

            Constructor constructor = cls.getConstructor(null);
            System.out.println(constructor);
            constructor = cls.getConstructor(int.class, String.class, int.class);
            System.out.println(constructor);
        } catch (ClassNotFoundException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
