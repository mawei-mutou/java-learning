package date20191231.package1;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/12/31
 * time        : 17:20
 * description :
 */
public class TextOperator01 {
    public static void main(String[] args) {
        byte a = 1;
        int b = 2;
        long b2 = 3l;
        //byte c = a + b;//错误，int不能自动转为byte
       // int c2 = b2 + b;//错误，long不能自动转为int
        float f1= 3.14f;//float型声明时必须在后面加f
        float d = b + b2;
        //float d2 = f1 + 6.2;//错误，6.2默认为int型
        //测试自增自减
        int p = 3;
        int q = p++;//先赋值后p自增
        System.out.println("p = " + p + "\nb=" + b);
        int h = 3;
        int n = ++h;//h先自增在赋值给n;
        System.out.println("h = " + h + "\nn= " + n);
        int wi = 3;
        int bi = 4;
        a += b;//相当于a= a+b
        System.out.println("wi=" + wi + "\nbi=" + bi);

        wi = 3;
        bi = 4;
        wi *= bi + 3;//先执行等号后面的在执行左边的
        System.out.println("wi=" + wi+"\nbi="+bi);
        int hi = 3;
        System.out.println(hi == 3);
        System.out.println(hi != 3);
        System.out.println(hi < 5);
        char bh = 'a';
        char ch = 'c';
        System.out.println(bh);
        System.out.println(0 + bh);
        System.out.println(0 + ch);
        System.out.println(bh < ch);
    }
}
