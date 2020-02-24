package date20200222;

import date20200221.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/22
 * time        : 20:27
 * description :
 */
public class Demo02 {
    public Demo02() throws NoSuchMethodException {
    }

    public static void main(String[] args) throws NoSuchMethodException {

        //获得指定方法参数泛型信息
        Method m = Demo02.class.getDeclaredMethod("test01", Map.class, List.class);
        Type[] t = m.getGenericParameterTypes();//获取泛型参数类型
        for (Type type : t) {
            System.out.println("#"+type);
            if (type instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                for (Type type1 : types) {
                    System.out.println("泛型类型："+type1);
                }
            }
        }
        System.out.println("------------------------");
        //获得指定方法返回值泛型信息
        Method m2 = Demo02.class.getDeclaredMethod("tes02");
        Type t2 = m2.getGenericReturnType();
        if (t2 instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) t2).getActualTypeArguments();
            for (Type temp : types) {
                System.out.println("泛型类型："+temp);
            }
        }
    }

    private void test01(Map<String, User> map, List<User> list) {
        System.out.println("Demon07.test01 ");
    }
    private Map<Integer, User> tes02() {
        System.out.println("Demon07.test02");
        return null;
    }

}
