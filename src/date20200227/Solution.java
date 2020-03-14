package date20200227;

import static javafx.scene.input.KeyCode.M;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/11
 * time        : 21:23
 * description :
 */

public class Solution {
    public static void main(String[] args) {
        String a = "MCMXCIV";
        Solution s=new Solution();
        //s.romanToInt(a);
        //System.out.println(s.reInt('M'));
        System.out.println(s.romanToInt(a));
    }

    public int romanToInt(String s) {
        char[] str=s.toCharArray();
//        for (char temp : str) {
//            System.out.println(temp);
//        }
        int len = str.length;
        int sum=0;
        if (len == 1) {
            return reInt(str[0]);
        } else {
            for (int i=0;i<len;i++) {
                if (i < len - 1) {
                    if (reInt(str[i]) >= reInt(str[i + 1])) {
                        sum += reInt(str[i]);
                    } else {
                        sum -= reInt(str[i]);
                    }
                } else {
                    sum += reInt(str[i]);
                }
            }
        }
        return sum;
    }

    public int reInt(char a) {
        switch (a) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}