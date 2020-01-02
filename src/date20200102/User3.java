package date20200102;

import static date20200102.User2.printCompany;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 17:14
 * description :
 */
public class User3 {
    int id ;
    String name;
    String pwd;
    static String company;

    //静态初始化块，在加载类时会执行初始化块
    static{
        System.out.println("执行类的初始化工作");
        company = "腾讯";
        printCompany();
    }

    public static void printCompany() {
        System.out.println(company);

    }

    public static void main(String[] args) {
       User u3 = null;//创建对象，但是啥也没做
    }
}
