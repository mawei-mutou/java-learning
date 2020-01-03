package date20200103;

import date20200101.TestConvert;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 15:24
 * description :
 */
public class TestSuper01 {
    public static void main(String[] args) {
        new ChildClass().f();
    }
}

//创建父类
class FatherClass1{
    public int value;

    public void f() {
        value = 100;
        System.out.println("FatherClass.Value=" + value);
    }
}

//创建子类
class ChildClass extends FatherClass1 {
    public int value;

    //对父类方法的重写
    public void f() {
        value = 200;
        super.f();//调用父类对象的普通的方法
        System.out.println("ChildClass.value=" + value);
        System.out.println(value);
        System.out.println(super.value);//调用父类的成员变量

    }
}
class Pkk extends TestConvert {

    public Pkk(int id, String name, String pwd) {
    }
}

