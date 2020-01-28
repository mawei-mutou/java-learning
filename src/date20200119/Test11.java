package date20200119;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/19
 * time        : 20:05
 * description :
 */
public class Test11 {
    public static void main(String[] args) {
        Person4 a =new Person4();
        a.setName("中国");
        String n = a.getName();
        System.out.println(n);

        a.setAge(18);
        System.out.println(a.getAge());
    }
}
