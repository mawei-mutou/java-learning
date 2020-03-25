package date20200321.sorm.utils;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:45
 * description :封装了字符串常用的操作
 */
public class StringUtils {
    /**
     * 将目标字符串首字母变为大写
     * @param string 目标字符串
     * @return 首字母变为大写的字符串
     */
    public static String firstChar2UpperCase(String string) {
        //abc-->Abc
        return string.toUpperCase().substring(0, 1) + string.substring(1);
    }
}
