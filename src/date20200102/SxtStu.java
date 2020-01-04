package date20200102;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 10:51
 * description :
 */
public class SxtStu {
    static String teacher="gaoqi";

    String teacher2="gaoqi111";

    //属性fields
    int id=11;
    String name;
    int age=(int)(Math.random()*1000);
    Computer comp =new Computer();

    static void testStaticMehod(){
        new SxtStu().inLessonV2();
    }

    void inLessonV2(){
        System.out.println(this.name);
        System.out.println("现在的老师是: "+teacher2);
        teacher2="gaoqi222";
    }
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

    void inLesson(){
        System.out.println("现在的老师是: "+teacher);
        teacher="gaoqi2222";
    }


    void play() {
        System.out.println("我在玩游戏！王者荣耀");
    }

    //程序执行的入口，必须要有
    public static void main(String[] args) {
//        SxtStu stu = new SxtStu();
//        stu.id = 1001;
//        stu.name = "yaodong";
//        stu.age = 18;
//        stu.comp.brand = "Lenove";
//
//        stu.play();
//        stu.study();
        SxtStu st1 = new SxtStu();
        SxtStu st2 = new SxtStu();
        st1.inLesson();
        st2.inLesson();
        System.out.println("---------------------------");
        st1.inLessonV2();
        st2.inLessonV2();

        System.out.println("---------------------------");
        System.out.println(st1.age);
        System.out.println(st2.age);
    }
}

class Computer{
    String brand;

}

