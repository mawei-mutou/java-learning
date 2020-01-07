package date20200107;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 13:38
 * description :
 */
public class Test2DimensionArray {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] =new int[] {15, 22, 33};
        a[1] = new int[]{65, 5, 36, 12};
        a[2] = new int[]{2, 56, 98, 77};

        //静态初始化二维数组
        int[][] b = {
                {20, 12},
                {65, 458, 87},
                {89, 5, 46}
        };

        System.out.println(Arrays.toString(a[0]));//若直接打印a则返回的是a0,a1,a2的内容，为三个数组的地址
        //Arrays.sort(a);二维数组不能这样排序
        System.out.println(Arrays.toString(a));

    }
}
