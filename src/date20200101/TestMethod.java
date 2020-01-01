package date20200101;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 测试方法的基本使用
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 21:09
 * description :
 */
public class TestMethod {
    public static void main(String[] args) {
        TestMethod tm = new TestMethod();
        tm.printSxt();
        tm.add(30, 40, 50);
        int p =tm.add2(84,89,98)+100;
        }
    void printSxt(){
        System.out.println("北京尚学堂");
        System.out.println("上海尚学堂");
    }

    void add(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println(sum);
    }
    int add2(int d, int e, int f) {
        int sum2 = d + e + f;
        System.out.println(sum2);
        return sum2;
    }
//方法的重载
    public static int add(int n1, int n2) {
        int sum = n1 + n2;
        return sum;
    }

    public static int add(int n3, int n4, double n5) {
        int sum = n3 + n4 + (int)n5;
        return sum;
    }

    public static int add(int n3, double n5, int n4) {
        int sum = n3 + n4 + (int) n5;
        return sum;
    }//方法重载：方法名字相同、参数个数、类型或者顺序不同。返回值类型不同，参数名称不同不构成方法的重载

}
