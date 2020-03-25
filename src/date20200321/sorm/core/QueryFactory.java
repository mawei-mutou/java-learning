package date20200321.sorm.core;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 19:02
 * description :
 */
public class QueryFactory {

    private static QueryFactory factory = new QueryFactory();
    private static Query prototypeObj;//原型对象

    static{
        Class c = null;//加载指定的query类
        try {
            c = Class.forName(DBManager.getConf().getQueryClass());
            prototypeObj = (Query) c.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private QueryFactory() {

    }//构造器私有化
    public static Query createQuery() {
        try {
            return (Query) prototypeObj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
