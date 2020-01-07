package date20200107;

/**检测冒泡排序法
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 14:37
 * description :
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {3, 1, 6, 2, 9, 0, 7, 4, 5, 8};

        int[] values2 = new int[10];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = (int) (Math.random() * 100);
        }
        Sort temp = new Sort();
        temp.ArraysSort(values);

        temp.ArraysSort(values2);
        for (int a : values) {
            System.out.printf("%d\t",a);
        }
        System.out.println();
        for (int a : values2) {
            System.out.printf("%d\t",a);
        }
    }
}

class Sort{
    int[] ArraysSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int count = 0;
            int length =a.length;
            for (int j = 0; j < length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    count++;
                }
            }
            length--;
            if(count ==0)
                break;
        }
        return a;
    }
}