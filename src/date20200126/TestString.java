package date20200126;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/26
 * time        : 12:19
 * description :
 */
public class TestString {
    public static void main(String[] args) {
        String str = "aaabbb";
        String str1 = str.substring(2);
        System.out.println(str1);

        String str2 = "hello Java";
        String str3 = "hello" + " Java";
        System.out.println(str2 == str3);

        String str4 = new String("hello Java");

        System.out.println(str2 == str4);

        String str5 = "hello";
        String str6 = " Java";
        String str7 = str5 + str6;

        System.out.println(str2 == str7);
        System.out.println(str7.equals(str2));
    }
}
