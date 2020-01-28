package date20200126;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 16:34
 * description :
 */
public class TestStringBuilder2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);
            sb.append(temp);
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.setCharAt(3, '姚');
        System.out.println(sb);
        sb.insert(0, '我').insert(2, '爱').insert(7, '你');
        System.out.println(sb);

    }
}
