package date20200126;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 22:52
 * description :
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar a = new GregorianCalendar(2020, 1, 26, 22, 54, 45);
        int year = a.get(a.YEAR);
        int month = a.get(a.MONTH);
        int day = a.get(a.DAY_OF_MONTH);
        int weekday = a.get(a.DAY_OF_WEEK);

        System.out.println(year);
        System.out.println(month);

        
    }
}
