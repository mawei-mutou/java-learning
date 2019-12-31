package Package1;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/12/31
 * time        : 16:53
 * description :
 */
public class TextPrimitiveDataType2 {
    public static void main(String[] args) {
        char a = 'T';
        char b = '上';
        char c = '\u0061';
        System.out.println(c);
        //转义字符
        System.out.println('a' + 'b');
        System.out.println("" + 'a' + 'b');
        System.out.println("" + 'a' + '\'' + 'b');
        System.out.println("a" + 'a' + '\n' + 'b');
        String d = "avc";
        System.out.println(d);
        System.out.printf("%s", a);
        //测试布尔型
        boolean man = true;
        if (man) {
            System.out.println('\n'+"男性");

        }
    }
}
