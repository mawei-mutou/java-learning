package date20200221;

import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 11:51
 * description :
 */
public class Demo01 {
    //测试内置注解Override，Deprecated,SuppressWarning
    @Override
    public String toString() {
        return null;
    }

    @SuppressWarnings(value = "method")
    public static void main(String[] args) {
        Date date = new Date();
        date.parse("dd");

        Demo01 demon = new Demo01();
        demon.test01();
    }

    //自定义一个Deprecated方法
    @Deprecated
    public void test01() {
    }


}
