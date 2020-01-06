package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 19:34
 * description :
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("abc");
        String str3 = "abc" + "defh";//可以拼接
        String str4 = "18"+ 19;//这里的+为字符拼接符，不是加号
        System.out.println(str4);

        System.out.println("#####################");
        String str10 = "yao";
        String str11 = "yao";
        String str12 = new String("yao");

        System.out.println(str10 == str11);
        System.out.println(str10 == str12);//为false，因为str12为新的对象的地址，而10和11都是直接在常量池里的


        //字符比较时一般用equals去比较内容
        System.out.println(str10.equals(str12));//此时是一样的为true

    }
}
