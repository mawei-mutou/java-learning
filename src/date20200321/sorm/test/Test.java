package date20200321.sorm.test;

import date20200321.sorm.core.MySqlQuery;
import date20200321.sorm.core.Query;
import date20200321.sorm.core.QueryFactory;
import date20200321.sorm.po.Yao3;

import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/25
 * time        : 16:40
 * description :
 */
public class Test {
    //MySqlQuery s=
    public static void main(String[] args) {
        Query query = QueryFactory.createQuery();
        String sql = "select id,age,name from yao3 where age>? and id<?";
        List<Yao3> list = query.queryRows(sql, Yao3.class, new Object[]{10, 5});
        for (Yao3 y : list) {
            System.out.println(y.getName());
        }
    }
}
