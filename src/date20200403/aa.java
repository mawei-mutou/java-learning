package date20200403;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/4/3
 * time        : 16:10
 * description :
 */
public class aa {
    public static void main(String[] args) {
        String a = "dfsd5df6jdhg   fh  g7fh";
//        String[] b = a.split("[\\d\\s]");
        String[] b = a.split("");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+"   ");
        }
    }
}
