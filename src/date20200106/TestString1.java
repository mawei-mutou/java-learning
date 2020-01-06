package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 19:47
 * description :
 */
public class TestString1 {
    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//提取下标为3的字符
        System.out.println(s2.length());//字符串的长度
        System.out.println(s1.equals(s2));//比较两个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写，比较两个字符串长度是否相等
        System.out.println(s1.indexOf("Java"));//返回s1中第一次出现Java的下标此处为5
        System.out.println(s1.indexOf("apple"));//若没有apple则返回-1

        String s = s1.replace('a','b');//将s1中的a替换为b
        System.out.println("result is:" + s);


        String ss = "";
        String ss1 = "How are you?";

        System.out.println(s1.startsWith("How"));//检测s1是否以How开始
        System.out.println(s1.endsWith("you"));//检测s1是否以you结尾

        s = ss1.substring(4);//截取s1中下标为4开始直到字符串结束位置的子字符串
        System.out.println(s);
        s = ss1.substring(4,7);//截取s1中下标为4开始直到下标为7的子字符串不包括7
        System.out.println(s);


        s = ss1.toLowerCase();//将s1转为小写赋给s
        System.out.println(s);
        s = ss1.toUpperCase();//将s1转为大写赋给s
        System.out.println(s);

        String p = "  How old are you？";
        s = p.trim();//将s1去除首位的空格，中间的不能去除
        System.out.println(s);
        System.out.println(p);//p不会改变

    }
}
