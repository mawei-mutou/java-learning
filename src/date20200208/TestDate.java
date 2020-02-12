package date20200208;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/8
 * time        : 10:46
 * description :
 */
public class TestDate {
    public static void main(String[] args) {
        Date df = new Date();
        DateFormat df2 = new SimpleDateFormat("mm:ss");
        System.out.println(df2.format(df));

        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd  hh-mm-ss");
        Date t=null;
        try {
             t = df3.parse("2020-02-08 10-51-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(t);

        System.out.println(df);

        long now = System.currentTimeMillis();
    }
}
