package date20200102;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 16:41
 * description :
 */
public class User2 {

    //成员变量
    int id;
    String name;
    String pwd;//密码

    static String company = "北京尚学堂";//静态变量显示为斜体，从属与类

    //构造方法
    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //普通方法
    public void login() {
        System.out.println("登录：" + name);
    }

    //静态方法
    public static void printCompany() {
        //login();//在静态方法里不能调用非静态的方法和变量,但是可以调用静态的方法和变量如32行
        System.out.println(company);
    }

    public static void main(String[] args) {
        User2 u = new User2(101, "姚小二");//创建对象
        u.printCompany();//而对象则可调用静态的方法和静态的变量
        u.company = "百度";
        System.out.println(u.company);
        User2.printCompany();//静态方法里面调用类里的另一个静态方法, 类只能调用属于类的方法和变量
        User2.company = "北京阿里巴巴";//比如它只能调用static的方法和变量，不能调用其它
        User2.printCompany();
        System.out.println(u.company);
    }
}
