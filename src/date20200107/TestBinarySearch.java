package date20200107;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 15:10
 * description :
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] a = new int[10];

        //初始化数组
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        System.out.println("初始数组序列为：");
        for (int temp : a) {
            System.out.printf("%d\t", temp);
        }
        System.out.println();

        //对数组进行排序
        Sort p = new Sort();
        p.ArraysSort(a);

        System.out.println("排序后的数组序列为：");
        for (int temp : a) {
            System.out.printf("%d\t", temp);
        }
        System.out.println();

        //用折半查找法查找目标
        Finding temp = new Finding();
        int e = (int) (Math.random() * 100);
        temp.binarySearch(a, e);

        if(temp.temp>0)
            System.out.println("查找目标为：" + e + "\t目标下标为：" + temp.temp);
        else
            System.out.println("查找目标为：" + e + "\t目标不在数组中");

    }
}

class Finding{

    int temp =0;

    int binarySearch(int[] a, int e) {
        int low = 0;

        int high =a.length;
        int mid = a.length/2;
        while ((low != high)&&(low<high)) {
            if (e == a[mid])
                break;
            else if (e < a[mid]) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else {
                low = mid +1;
                mid = (low + high) / 2;
            }
        }
        if (a[mid] == e) {
            temp = mid;
        } else {
            temp = -1;
        }
        return temp;
    }
}
