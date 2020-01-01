package date20200101;

/**
 * 测试if
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 17:06
 * description :
 */
public class TextIf {
    public static void main(String[] args) {
        double d = Math.random();
        System.out.println(d);
        int h = (int) (6 * Math.random() + 1);
        System.out.println(h);
        if (h <= 3) {
            System.out.println("小");
            System.out.println("小小小");
        }
        System.out.println("#################");
        //通过投三个骰子看看今天的手气如何
        int i = (int) (6 * Math.random() + 1);
        int j = (int) (6 * Math.random() + 1);
        int k = (int) (6 * Math.random() + 1);
        int count = i + j + k;
        //如果count大于15则说明今天运气不错
        if (count > 15) {
            System.out.println("今天手气不错");
        }
        //如果count在10到15之间则手气一般
        if (count >= 10 && count <= 15) {
            System.out.println("今天手气一般");
        }
        //如果count小于10，则今天手气差
        if (count < 10) {
            System.out.println("今天手气差");
        }
        System.out.println("得了"+count+"分");
    }
}
