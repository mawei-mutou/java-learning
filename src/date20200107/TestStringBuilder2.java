package date20200107;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 17:45
 * description :
 */
public class TestStringBuilder2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);

        for (int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);
            sb.append(temp);
        }

        System.out.println(sb);

        sb.reverse();//倒序
        System.out.println(sb);
        sb.setCharAt(0, '我');//在下标为0处的值变为我
        System.out.println(sb);

        sb.insert(2, '爱').insert(3, '你');//在下标为2，3的地方插入字符
        sb.insert(7,"中国");//插入字符串
        System.out.println(sb);

        sb.delete(4, 7);
        System.out.println(sb);//删除从4到7之间的字符子串，不包括7

        String ppp = sb.substring(0, 6);
        System.out.println(ppp);
    }
}
