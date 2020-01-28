package date20200126;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 22:08
 * description :
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String str = df.format(new Date());
        System.out.println(str);

        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        Date date = df2.parse("2018年05月28日 12：26：15");
        System.out.println(date);
    }
}
