package date20200224;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/24
 * time        : 10:58
 * description :理解类加载初始化过程
 */
public class Demo0 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("哈哈哈");
//        System.out.println(A.height);//调用final常量时不会初始化所在类
//        System.out.println(A.width);//调用静态变量时会初始化所在类
//        A a = new A();
//        System.out.println("主函数");
//
//        A b = new A();//同一个类只会加载一次，因此静态块只会执行一次


//        Class clazz = Class.forName("date20200224.A");//使用反射也会加载所在的类
//        clazz.newInstance();
//
//        A[] a = new A[10];// 通过数组定义类引用，不会触发此类的初始化
//
//        //当访问一个静态域时，只有真正声明这个域的类才会被初始化
        System.out.println(B.width);

    }

    static{
        System.out.println("初始化Demo0");
    }
}

class B extends A {
    static{
        System.out.println("初始化B");
   }
}


class A extends A_Father{
    public  A() {
        System.out.println("A的构造器！width="+width);
    }

    public static int width = 100;//调用静态属性和静态方法时会初始化所在的类（包括其父类）
    public static final int height = 200;//调用常量时不会初始化所在的类

   static {
       System.out.println("类的初始化11:" + width);
       width = 200;
       System.out.println("22:"+width);
    }
}

class A_Father {
    static {
        System.out.println("初始化A_Father");
    }
}
