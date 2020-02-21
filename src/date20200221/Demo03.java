package date20200221;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 13:58
 * description :
 */
public class Demo03 {
    private static Class clazz;

    public static void main(String[] args) {
        {
            try {
                clazz = Class.forName("date20200221.SxtStudent");
                SxtStudent s = new SxtStudent();
                s =(SxtStudent) clazz.getConstructor().newInstance();

                //拿到类的所以注解信息
                Annotation[] annotations = clazz.getAnnotations();
                for (Annotation temp : annotations) {
                    System.out.println(temp.toString());
                }
                //根据注解名去拿特定的注解
                SxtTable sxt = (SxtTable)clazz.getAnnotation(SxtTable.class);
                System.out.println(sxt.value());

                //获取属性的注解
                Field f = clazz.getDeclaredField("name");
                SxtField sxtField = f.getAnnotation(SxtField.class);
                System.out.println(f.getName());
                System.out.println(sxtField.columnName()+"->"+sxtField.type()+"-->"+sxtField.length());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
