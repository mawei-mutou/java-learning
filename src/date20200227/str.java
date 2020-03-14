package date20200227;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/13
 * time        : 19:41
 * description :
 */
public class str {
    public static void main(String[] args) {
       String str="A";
       byte[] b=str.getBytes();
        System.out.println(b.length);
        System.out.println(b[0]);
        System.out.println(b[1]);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        //System.out.println(b);
    }
}
