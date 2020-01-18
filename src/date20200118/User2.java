package date20200118;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/18
 * time        : 21:04
 * description :
 */
public class User2 {
    int id;
    String name = "wo ";
    String pwd;
    static String company = "北京尚学堂";

    public void login() {
        printCompany();
        System.out.println("登录：" + name);

    }

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void printCompany() {
        System.out.println(company);
    }

    public static void main(String[] args) {
        User2 u = new User2(101, "高小七");
        User2.printCompany();
        User2.company = "百度";
        User2.printCompany();
        u.company = "阿里";
        u.printCompany();
    }
}
