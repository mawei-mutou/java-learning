package date20200108;

/**测试异常
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 14:22
 * description :
 */
public class TestException01 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        //System.out.println(b / a);

        //空指针异常
        String str = null;
        //str.length;

        //类型强制转换异常
        class Animal {
        }

        class Dog extends Animal {
        }

        class Cat extends Animal {
        }

        //Dog dog = new Cat();//Cat 不是dog的子类所以不能这样强制转换


        //数组越界异常
        int[] arr = new int[3];
        System.out.println(arr[3]);

    }
}

