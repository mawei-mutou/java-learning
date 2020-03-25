package date20200321.sorm.test;

import date20200321.sorm.core.Query;
import date20200321.sorm.core.QueryFactory;
import date20200321.sorm.po.Yao3;

import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/25
 * time        : 17:52
 * description :
 */
public class Test2 {
    public static void test1() {
        Query query = QueryFactory.createQuery();
        String sql = "select id,age,name from yao3 where age>? and id<?";
        List<Yao3> list = query.queryRows(sql, Yao3.class, new Object[]{10, 5});
//        for (Yao3 y : list) {
//            System.out.println(y.getName());
//        }
    }

    public static void test2() {
        long start = System.currentTimeMillis();

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            test1();
        }
        long end = System.currentTimeMillis();
        System.out.println("加连接池的时间："+(end - start));
    }
}
