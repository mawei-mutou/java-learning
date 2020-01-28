package date20200125;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/25
 * time        : 18:05
 * description :
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("def");
        String str3 = "abc" + "defgh";
        String str4 = "18" + 19;
        System.out.println(str4);


        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        String str10 = "wo";
        String str11 = "wo";
        String str12 = new String("wo");
        System.out.println(str10 == str11);
        System.out.println(str10 == str12);

        System.out.println(str12.equals(str10));

    }
}
