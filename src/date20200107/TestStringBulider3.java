package date20200107;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 17:57
 * description :
 */
public class TestStringBulider3 {
    public static void main(String[] args) {

        //使用String进行字符串拼接
        String str8 = "";//空字符串

        long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余空间
        System.out.println(num1);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str8 = str8 +i;//这里相当于产生了200个对象，对内存和效率影响很大，极大不好
        }

        //System.out.println(str8);

        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();

        System.out.println("占用内存为：" + (num1 - num2));
        System.out.println("占用时间为：" + (time2 - time1));

        //使用StringBuilder进行字符串拼接
        StringBuilder sb1 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sb1.append(i);
        }

       //        System.out.println(str8);

        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();

        System.out.println("StringBuilder占用内存为：" + (num3 - num4));
        System.out.println("StringBuilder占用时间为：" + (time4 - time3));
    }
}
