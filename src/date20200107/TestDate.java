package date20200107;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Calendar;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 19:46
 * description :
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date();//当前时间
        System.out.println(d);
        System.out.println(d.getTime());//以毫秒返回从1970到当前时间
    }
}
