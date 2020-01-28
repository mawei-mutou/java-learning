package date20200126;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 12:25
 * description :
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdefg");
        System.out.println(sb.hashCode());
        System.out.println(sb);

        sb.setCharAt(2, 'M');
        System.out.println(sb.hashCode());
        System.out.println(sb);
    }
}
