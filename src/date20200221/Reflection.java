package date20200221;

import date20200218.LoginServlet;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 15:09
 * description :通过反射获取各种类型的Class对象。
 */
public class Reflection {
    private static Class clazz;

    public static void main(String[] args) {
        {
            try {
                clazz = Class.forName("date20200220.LoginServlet");//一个类对应一个Class对象
                System.out.println(clazz.hashCode());

                clazz = LoginServlet.class;
                LoginServlet loginServlet = new LoginServlet();
                clazz = loginServlet.getClass();

                clazz = int.class;
                System.out.println(clazz.hashCode());
                int[] a = new int[5];
                clazz = a.getClass();
                System.out.println(clazz.hashCode());

                String aa = "aaaa";
                clazz = aa.getClass();
                System.out.println(clazz.hashCode());

                clazz = String.class;
                System.out.println(clazz.hashCode());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
