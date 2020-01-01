package date20200101;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 15:54
 * description :
 */
public class TextConvertError {
    public static void main(String[] args) {
        int money = 100000000;//十亿
        int years = 20;
        //返回的total是负数，超过了int 的范围
        int total = money * years;
        System.out.println("total=" + total);
        //返回的total仍然是负数，默认为int,因此结果会转成int值；再转成long，但是已经发生数据的丢失了
        long total1 = money * years;
        System.out.println("total1=" + total1);
        //返回的 total2 正确：先将其中一个因子变为long;整个表达式发生提升，全部用long来计算
        long total2 = money * ((long) years);
        System.out.println("total2=" + total2);
        long total3 = 34L * 3223 * years * 223423;
        System.out.println(total3);
        //命名问题
        int L = 2;
        long a = 2345L;//建议使用大写L
        System.out.println(L + 1);

    }
}
