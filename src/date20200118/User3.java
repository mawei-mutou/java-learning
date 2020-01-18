package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 21:27
 * description :
 */
public class User3 {
    int id;
    String name;
    static String company = "百度";

    static{
        System.out.println(company);
        company = "阿里";
        printCompany();

        System.out.println(company);
    }

    public void login() {
        System.out.println("dsf ");

    }

    public static void printCompany() {
        System.out.println(company);
        company = "腾讯";
    }

    public static void main(String[] args) {
        User3 u = null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
