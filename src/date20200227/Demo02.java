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
public class Demo02 {
    public static void main(String[] args) {
        //表达式对象
        Pattern pattern = Pattern.compile("\\*");//注意，这里打\需要转义多加一个\
        //匹配对象
        Matcher matcher = pattern.matcher("ddfsdff***dfdsfsdf*23233488dddd");
        String str = matcher.replaceAll("\\$");//特殊符号必须使用转义
        System.out.println(str);
    }
}
