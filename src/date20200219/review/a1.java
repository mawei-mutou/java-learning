package date20200219;

import date20200218.WebUtil;

import java.lang.reflect.InvocationTargetException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 9:24
 * description :
 */
public class a1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cls = Class.forName("date20200218.WebUtil");
        System.out.println(cls);
        WebUtil web = (WebUtil) cls.getConstructor().newInstance();
        System.out.println(web);
    }
}
