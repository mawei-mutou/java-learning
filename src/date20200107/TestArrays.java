package date20200107;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 13:15
 * description :
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] a = {15,84,56,38,75,55};
        String[] b = {"abc", "aba","apple", "people", "name", "interface", "extends"};

        System.out.println(a);//直接这样打的话输出a的地址和a的类型
        System.out.println(b);

        System.out.println(Arrays.toString(a));//以字符串形式输出数组内容
        System.out.println(Arrays.toString(b));

        Arrays.sort(a);//将数组a进行排序，为升序吧
        Arrays.sort(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.binarySearch(a, 56));//在数组a中用二分查找法查找56，存在则返回下标，若不存在则返回-1
        System.out.println(Arrays.binarySearch(b, "abc"));
    }
}
