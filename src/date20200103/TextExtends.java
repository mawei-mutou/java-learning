package date20200103;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 11:05
 * description :
 */
public class TextExtends {
    public static void main(String[] args) {
        Student stu = new Student();//这里采用默认构造方法创建对象若要给对象的属性赋值只能一一赋值
        stu.name = "姚小二";
        stu.age = 18;
        stu.height = 170;
        stu.rest();
        Student stu2 = new Student("姚小三", 14, 150, "化学专业");//这里用第二种构造方法创建对象直接赋值
        stu2.study();

        //检测对象是否属于某个类，用instanceof关键字
        System.out.println(stu2 instanceof Student);
        System.out.println(stu2 instanceof Person);
        System.out.println(stu2 instanceof Object);//Object是最底层的类
        System.out.println(new Person() instanceof  Object);//这里新建了一个Person的对象检测它是否属于类Object
    }
}

//创建类
class Person /*extends Object*/ {
    String name;
    int age;
    int height;

    public void rest() {
        System.out.println("休息一会");
    }
}

class Student extends Person{
    String major;

    public void study(){
        System.out.println("学习两小时");
    }
    //构造方法
    public Student(String name, int age, int height, String major) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.major = major;
    }
    //构造无参数的构造方法
    public Student() {
    }
}

