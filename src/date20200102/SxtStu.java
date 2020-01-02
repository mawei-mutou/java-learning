package date20200102;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 10:51
 * description :
 */
public class SxtStu {
    //属性fields
    int id;
    String name;
    int age;
    Computer comp =new Computer();

    //构造方法
    SxtStu() {

    }//如果没有自定义系统会自动添加
    void study (){
//        Computer c1 = new Computer();
//        c1.brand = "联想";
//        comp = c1;
   //     comp = new Computer();
        System.out.println("我在认真学习！电脑是："+comp.brand);
    }

    void play() {
        System.out.println("我在玩游戏！王者荣耀");
    }

    //程序执行的入口，必须要有
    public static void main(String[] args) {
        SxtStu stu = new SxtStu();
        stu.id = 1001;
        stu.name = "yaodong";
        stu.age = 18;
        stu.comp.brand = "Lenove";

        stu.play();
        stu.study();
    }
}

class Computer{
    String brand;

}

