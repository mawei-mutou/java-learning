package Package1;

/**测试常量
 * created with IntelliJ IDEA
 *
 * author      : yaodong
 * date        : 2019/12/31
 * time        : 10:18
 * description :
 */
public class TestConstant {
    public static void main(String[] args) {
        //int age = 18;
        String name = "yao";//此时name为变量；
        final String NAM = "dong";//这里的NAM为符号常量，不可再更改；
        int b = 015;
        int d =0x188;
        System.out.println(b);
        System.out.println(d);
        byte age = 30;
        short salary = 3999;
        int population = 2000000000;//整型常量默认为int；
        long globalPopulation = 7400000000000L;//若要表示为long型则需要在;后面添加l或L;

    }
}
