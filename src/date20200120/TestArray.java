package date20200120;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/20
 * time        : 17:48
 * description :
 */
public class TestArray {

    public static void main(String[] args) {
        User[] u = new User[3];
        u[0] = new User(1, "高淇");
        u[1] = new User(2, "姚东");
        u[2] = new User(3, "高二");

        System.out.println(u.length);
        User[] y = {new User(4, "d"), new User(5, "sdfs"), new User(6, "sf")};
        System.out.println(y.length);
        System.out.println(y[0].getName());

    }
}


class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}