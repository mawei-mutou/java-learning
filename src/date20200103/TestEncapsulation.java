package date20200103;

import date20200102.*;
/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 16:42
 * description :
 */
public class TestEncapsulation {
    public static void main(String[] args) {
    HuMan h =new HuMan();
    //h.age = 23;//不同类不能使用private
        h.name = "姚小二";

    Person4 p4 = new Person4();//不能访问被private修饰的属性和方法
    //比如p4.age;
        Person4 p5 = new Person4();
        p4.setAge(-14);
        p4.setAge(25);
        System.out.println(p4.getAge());
        System.out.println(p5.getAge());
    }
}

class HuMan{
    private  int age;//private只能在自己类里面使用
    protected int height;//protected可以被自己、同包和不同包里的子类使用，不是子类不能使用
    String name;//默认类是可以被自己、同包里使用
    void sayAge() {
        System.out.println(age);//自己类可以使用private
    }
}

class Boy extends HuMan {
    void sayHello() {
        //System.out.println(age);//子类不能使用父类的privagte属性
    }
}

class Girl extends User4 {
    Girl mm = new Girl();
}
