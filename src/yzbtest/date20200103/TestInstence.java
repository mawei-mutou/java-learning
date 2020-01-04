package yzbtest.date20200103;

public class TestInstence {

    private class TestIn{
        // 内部类
    }

    public static void main(String[] args) {
//        Student st1 = new Student();
//        System.out.println(st1 instanceof Human);
        new LittleStudent();
    }

}

class Human{
    public Human() {
        System.out.println("human created");
    }

    public Student sayHello() throws RuntimeException{
        return new Student();
    }
}

class Student extends Human{

    public Student() {
        System.out.println("Student created");
    }
    // 子类返回类型的范围 要比父类的小或者等于 且有继承关系
//    @Override
//    public Human sayHello() {
//        return null;
//    }

    @Override
    public LittleStudent sayHello() throws RuntimeException{
        return null;
    }
// 不能比父类闯更多的祸
//    @Override
//    public LittleStudent sayHello() throws Exception{
//        return null;
//    }

//    @Override
//    public int sayHello() {
//        return 10;
//    }
}

class LittleStudent extends Student{

    public LittleStudent() {
        System.out.println("LittleStudent created!");
    }
}