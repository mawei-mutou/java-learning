package date20200107;

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
 * date        : 2020/1/7
 * time        : 21:38
 * description :
 */
public class TestCalendar2 {
    public static void main(String[] args) throws ParseException {

        System.out.println("请输入日期（格式：2020-10-10）：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);

        Calendar c = new GregorianCalendar();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int max = c.getActualMaximum(Calendar.DATE);

        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= max; i++) {
            if (i == day) {
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
            } else{
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
            }


            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
