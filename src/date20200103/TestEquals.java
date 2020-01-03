package date20200103;

import java.util.Objects;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 14:29
 * description :
 */
public class TestEquals {
    public static void main(String[] args) {
        Object obj;
        String str;

        User u1 = new User(1000, "姚小二", "123455");
        User u2 = new User(1000, "姚小三", "123455");

        System.out.println(u1 == u2);//这里是判断u1和u2是否是同一个对象，即这两个所指的地址是否为同一个地址
        System.out.println(u1.equals(u2));//这里是调用了默认的object类里面的equals方法，和18行是一样的

        String str1 = new String("hhh");
        String str2 = new String("hhh");
//        System.out.println(str1);
//        str1 = "hello!";
//        str2 = "hello!";
        System.out.println(str1);
        System.out.println(str1 == str2);//判断地址是否一样
        System.out.println(str1.equals(str2));//判断内容是否一致

    }
}

class User {
    int id;
    String name;
    String pwd;

    public User(int id, String name, String pwd) {
        super();
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }


    //重写equals 方法,只判断内容的id是否一样
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//如果地址一样则一定是相同的
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;//将object 类强制转化为 user 类
        return id == user.id;
    }
}

