package date20200127;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/27
 * time        : 13:20
 * description :
 */
public class TestCalendar2 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期（格式为2020-01-01）：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);

        Calendar c = new GregorianCalendar();
        c.setTime(date);

        int aa = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("输入日期所在日为："+aa);

        int max = c.getActualMaximum(Calendar.DATE);
        System.out.println("所在月天数为：" + max);
        c.set(Calendar.DAY_OF_MONTH, 1);
        int bb = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("所在星期为："+bb);
        System.out.println("日\t一\t二\t三\t四\t五\t六");


        for (int i = 0; i < bb-1; i++) {
            System.out.print("\t");
        }

        for (int i = 0; i < max; i++) {
            if (c.get(Calendar.DAY_OF_MONTH) == aa) {
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
            } else {
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
            }

            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
