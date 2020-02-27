package date20200227;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/27
 * time        : 11:57
 * description :测试正则表达式的基本用法
 */
public class Demo03 {
    public static void main(String[] args) {
        String str = "dddfsdff***dfdsfsdf*23233488dddd";
        String[] strs = str.split("\\*+");
        for (String temp : strs) {
            System.out.println(temp);
        }
    }
}
