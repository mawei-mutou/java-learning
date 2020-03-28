package date20200321.sorm.core;

import java.lang.String;

import date20200321.sorm.po.Yao3;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/25
 * time        : 10:52
 * description :
 */
public class MySqlQuery extends Query{

    public static void testDML() {
        Yao3 y = new Yao3();
        y.setId(2);
        y.setAge(7);
        y.setName("姚丹");
        MySqlQuery m = new MySqlQuery();
        //m.delete(y);
        m.update(y, new String[]{"age", "name"});
    }

    public static void testQueryRows() {
        List<Yao3> list = new MySqlQuery().queryRows("select id,age,name from yao3 where age>? and id<?", Yao3.class, new Object[]{10, 5});
        for (Yao3 y : list) {
            System.out.println(y.getName());
        }
    }

    public static void main(String[] args) {
        Object obj = new MySqlQuery().queryValues("select count(*) from yao3 where age>?", new Object[]{10});
        System.out.println((Number)obj);
    }
}
