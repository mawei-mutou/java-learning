package date20200102;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 17:25
 * description :
 */
public class User4 {
    int id;
    String name;
    String pwd;

    //构造方法
    public User4(int id, String name) {
        this.id =id;
        this.name = name;
    }

    public void testParameterTransfer01(User4 u) {
        u.name = "高小八";
    }


    public void testParameterTransfer02(User4 u) {
        u = new User4(200, "高三");
    }

    public static void main(String[] args) {
        User4 u1 = new User4(100, "高小七");//将新对象的地址赋给了u1

        //调用方法01
        u1.testParameterTransfer01(u1);//将u1的值复制给u，u重新将所指地址出的对象的name属性变为了"高小八"
        System.out.println(u1.name);
        u1.testParameterTransfer02(u1);
        /*//将u1的值复制给02方法里面的u,由于在2方法中，新建了一个对象，并将新对象的地址赋给了u，
        u的值发生了变化，因此u1所指地址处的值没有发生变化*/
        System.out.println(u1.name);
    }
}
