package date20200102;

/**检测构造方法的重载
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 15:31
 * description :
 */
public class User {
    int id;
    String name;
    String pwd;//密码

    public User() {

    }

    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;//this 表示创建好的对象

    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;

    }

    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User(101, "姚小二");
        User u3 = new User(100, "小二", "123445");
    }
}
