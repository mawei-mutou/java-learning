package date20200107;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 17:12
 * description :
 */
public class TestStringBuilder {
    public static void main(String[] args) {


        String str1 = new String("sdfsafsf");
        String str = "fdfsd";//不可变的字符串序列
        int p = str.indexOf('f');
        System.out.println(p);

        String str2 = "aaaa" + " bbbbb";//相当于"aaaa bbbbb"
        String str3 = "aaaa bbbbb";
        System.out.println(str2 == str3);//这里是true

        String str4 = str2 + str3;
        System.out.println(str4);

        StringBuilder sb = new StringBuilder("dasdfsfsdfdsaf");//可变的字符串序列
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);


        sb.setCharAt(5, 'A');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
    }
}
