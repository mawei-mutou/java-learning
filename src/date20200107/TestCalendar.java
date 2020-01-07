package date20200107;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 20:54
 * description :
 */
public class TestCalendar {
    public static void main(String[] args) {
        //获得日期的相关元素
        Calendar a = new GregorianCalendar(2018, 7, 8, 8, 25, 58);
        Calendar c = new GregorianCalendar();//可以传值，也可以不传值，不传值则默认用现在的时间
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        int weekday = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("年："+year+"月："+month+"日："+day);

        //设置日期的相关元素
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.MONTH, 8);//设置月份
        c2.set(Calendar.YEAR, 2020);

        //日期的计算
        Calendar c3 = new GregorianCalendar();
        c3.add(Calendar.YEAR, 5);//在c3的基础上加5年

        printCalendar(c3);

    }
//将时间c安装我们想要的格式输出的方法,如2020年12月20日 24时25分23秒
    public static void printCalendar(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.println(year+"年"+month+"月"+day+"日"+hour+"时"+second+"分"+minute+"秒");
    }

}
