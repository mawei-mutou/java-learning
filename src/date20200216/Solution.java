package date20200216;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/16
 * time        : 21:58
 * description :
 */
public class Solution {
    public boolean isPalindrome(int x) {
        int x_1 = x;
        int y=0;
        if (x < 0) {
            System.out.println("not Palindrome");
            return false;
        }
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (y == x_1) {
            System.out.println(y+"\tis Palindrome");
            return true;
        } else {
            System.out.println("not Palindrome");
            return false;
        }
    }
}
