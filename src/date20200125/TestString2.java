package date20200125;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/25
 * time        : 18:19
 * description :
 */
public class TestString2 {
    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(0));
        System.out.println(s1.length());
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.indexOf("Java"));
        System.out.println(s1.indexOf("apple"));
        String s = s1.replace("o", "p");
        System.out.println(s);

        String s3 = "";
        String s4 = "How are you?";
        System.out.println(s4.startsWith("How"));
        System.out.println(s4.endsWith("are"));

        s = s1.substring(4);
        System.out.println(s);
        s = s1.substring(4, 7);
        System.out.println(s);


        s = s1.toLowerCase();
        System.out.println(s);
        s = s1.toUpperCase();
        System.out.println(s);
    }


}
