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
 * time        : 1:42
 * description :
 */
public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期（格式：2020-02-27）");//String str = "2020-02-27";
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);

        Calendar c = new GregorianCalendar();
        c.setTime(date);
        int aa = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(aa);
       // System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        c.set(Calendar.DAY_OF_MONTH, 1);
       // System.out.println(c.get(Calendar.DAY_OF_MONTH));

        for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++) {
            System.out.print("\t");
        }

        int max = c.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= max; i++) {
            if (c.get(Calendar.DAY_OF_MONTH) == aa) {
                System.out.print(c.get(Calendar.DAY_OF_MONTH) +"*"+ "\t");
               // System.out.print("*");
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
