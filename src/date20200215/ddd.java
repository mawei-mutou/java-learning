package date20200215;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 22:56
 * description :
 */
class Solution {
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.reverse(1534236469);
//    }

    public int reverse(int x) {
        long result = 0;


        boolean flag= true;
        int temp = Math.abs(x);
        int MIN = (int) Math.pow(2, 32) * (-1);
        int MAX = (int) (Math.pow(2, 32) -1);
        System.out.println("最小值为" + MIN + "\t最大值为：" + MAX);
        if ((x < MIN) || (x > MAX)) {
            System.out.println("输入错误");
            return 0;
        }
        if (x < 0) {
            flag = false;
        }
        while (temp > 0) {
            result = result*10+(temp % 10);
            temp = temp / 10;
        }

        if (flag == true&&result<=MAX) {
            System.out.println("结果为："+result);
            return (int)result;
        } else if (flag == false && -result >= MIN) {
            System.out.println("结果为：" + (-result));
            return (int)-result;
        }
        System.out.println("反转后超过范围！！");
        return 0;
    }
}
