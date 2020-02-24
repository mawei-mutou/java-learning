package date20200222;

import date20200221.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/22
 * time        : 10:05
 * description :检测反射性能
 * 1、setAeccible
 */
public class Demo01 {

    //private static User u;
    private static long startTime;
    private static long endTime;
    private static final long MAX = 2000000000L;

    //普通方法
    public static void test01() {
        User u = new User();
        startTime = System.currentTimeMillis();//记录开始时间
        for (int i = 0; i < MAX; i++) {
            u.getName();
        }
        endTime = System.currentTimeMillis();//记录结束时间

        System.out.println("test01:"+(endTime - startTime));
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getName");
        // method.setAccessible(true);没有设为true每次调用method.invoke会进行安全检查
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            method.invoke(u, null);//invoke是激活method,传入对象
        }
        endTime = System.currentTimeMillis();
        System.out.println("test02:"+(endTime - startTime));
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getName");
        method.setAccessible(true);//不需要进行安全检查，提高效率
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            method.invoke(u, null);
        }
        endTime = System.currentTimeMillis();
        System.out.println("test03:"+(endTime - startTime));
    }

    public static void main(String[] args) {
        test01();
        try {
            test02();
            test03();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
