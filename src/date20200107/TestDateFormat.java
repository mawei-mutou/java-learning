package date20200107;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 20:05
 * description :
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {

        //把时间对象按照”格式字符串指定的格式"转换成相应的字符串
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String str = df.format(new Date());
        System.out.println(str);

        //吧字符串安照“格式字符串指定的格式”转换成相应的时间对象
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        Date date = df1.parse("2020-12-12  08:23:55");
        System.out.println(date);

        //测试其他格式
        DateFormat df2 = new SimpleDateFormat("D");
        String str3 = df2.format(new Date());
        System.out.println(str3);


    }
}
