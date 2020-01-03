package date20200102;

import date20200101.TestMethod;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 16:15
 * description :
 */
public class TestThis {

    int a=1;//成员变量
    int b=2;//成员变量
    int c=3;//成员变量

//    静态块和代码块 这种写法不推荐
//    static {
//
//    }
//
//    {
//        a=2;
//    }

    public TestThis() {
    }

    //构造方法
    TestThis(int a, int b) {
        a = 0;//这里的a用就近原则，指15行里的a
        this.a = a;//这里加this的a指当前对象的a，即成员变量里的a，17行一样
        this.b = b;
    }

    TestThis(int a, int b, int c) {
        this(a, b);//在同一个类当中，用this关键字调用重载的构造方法，避免相同的初始化代码，在这里相当于this.a =a ;this.b = b
        this.c = c;
    }

    void sing() {
        System.out.println("姚小二，");
    }
    void eat() {
        this.sing();
        System.out.println("你妈妈叫你回家吃饭！");

    }

    public static void main(String[] args) {
        // hi是一个引用 指向新创建对象的内存地址
        TestThis hi = new TestThis(2, 3);
        hi.eat();
    }

}
