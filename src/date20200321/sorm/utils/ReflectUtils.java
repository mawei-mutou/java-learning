package date20200321.sorm.utils;

import java.lang.reflect.Method;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:45
 * description :
 */
public class ReflectUtils {

    /**
     * 调用obk对象对应属性filedName的get方法
     * @param fieldName
     * @param object
     * @return
     */
    public static Object invokeGet(String fieldName, Object object) {
        try {
            Class c = object.getClass();
            Method m = c.getMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
            return m.invoke(object, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param obj
     * @param columnName
     * @param columnValue
     */
    public static void invokeSet(Object obj, String columnName, Object columnValue) {
        try {
            Method m = obj.getClass().getMethod("set" + StringUtils.firstChar2UpperCase(columnName), columnValue.getClass());
            m.invoke(obj, columnValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
