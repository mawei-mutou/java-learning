package date20200221;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 20:01
 * description :
 */
public class Demo04 {
    private static Class cls;

    public static void main(String[] args) {
        try {
            cls = Class.forName("date20200221.User");
            User u1 = (User)cls.newInstance();
            Constructor<User> c = cls.getDeclaredConstructor(int.class, String.class, int.class);
            User u2=c.newInstance(120,  "姚东",16);
            System.out.println(u2.getName());

            //通过API调用普通方法
            Method method = cls.getDeclaredMethod("setName", String.class);
            method.invoke(u2, "姚西");//
            System.out.println(u2.getName());

            //通过API调用操作属性
            Field f = cls.getDeclaredField("name");
            f.setAccessible(true);//获取操作私有属性的权限
            f.set(u2, "木头");
            System.out.println(u2.getName());
            System.out.println(f.get(u2));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
