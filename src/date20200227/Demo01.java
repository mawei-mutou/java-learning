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
public class Demo01 {
    public static void main(String[] args) {
        //表达式对象
        Pattern pattern = Pattern.compile("\\w+");//注意，这里打\需要转义多加一个\
        //匹配对象
        Matcher matcher = pattern.matcher("ddfsdff***dfdsfsdf*23233488dddd");
        //boolean yesorno = matcher.matches();//matches方法是就整个字符串进行匹配
        //System.out.println(yesorno);
        int i = 0;
        boolean yesorno1 = true;
        while (yesorno1) {
            i++;
            yesorno1= matcher.find();//find方法是查找一个与模式匹配的子序列，再次调用时会接着前面的往后查找
            System.out.println(yesorno1+"-->"+i);
            if (yesorno1) {
                System.out.println(matcher.group(0));
            }

        }

        String str = matcher.replaceAll("\\$");
        System.out.println(str);


    }
}
