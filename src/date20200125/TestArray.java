package date20200125;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/25
 * time        : 18:57
 * description :
 */
public class TestArray {
    public static void main(String[] args) {
        String[] s1 = new String[5];
        String[] s2 = {"aa", "bb", "cc", "dd"};
        System.arraycopy(s2, 1, s1, 2, 2);
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        testBasicCopy2(s2,0);
    }

    public static String[] testBasicCopy2(String[] s,int index) {
        System.arraycopy(s, index+1, s, index, s.length - index-1);
        s[s.length - 1] = null;
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        return s;
    }

}
