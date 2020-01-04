package date20191231.package1;


import java.math.BigDecimal;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/12/31
 * time        : 15:44
 * description :
 */
public class TextPrimitiveDataType {
    public static void main(String[] args) {
        float a = 3.14f;
        double b = 6.28;
        double c = 628e-2;
        System.out.println(c);
        double f = 0.1;
        double d = 1.0 / 10;
        System.out.println(f == d);//结果为false
        float d1 = 423432423f;
        float d2 = d1 + 1;
        if (d1 == d2) {
            System.out.println("d1==d2");
        } else {
            System.out.println("d1!=d2");
        }
        int b11=(113+33)*99;
        System.out.println("#######");
        //使用精确浮点运行
        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd); // 0.5
        System.out.println(1.0 -0.1 - 0.1 - 0.1 - 0.1 - 0.1);

        BigDecimal bd2 = BigDecimal.valueOf(0.44);
        BigDecimal bd3 = BigDecimal.valueOf(4.4 / 10.0);
        System.out.println(bd2 == bd3);
        System.out.println(bd3);
        long cc = 1000L;
        int a111=1;
        a111++;
        if (a==1 & b==3){
            System.out.println("aa");
        }
        if (a==1 && b==3){
            System.out.println("aa");
        }

        if (a==1 || b==3){
            System.out.println("aa");
        }

        if (a==1 | (b++==3)){
            System.out.println("aa");
        }

    }
}
