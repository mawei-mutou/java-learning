package date20200103;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 17:10
 * description :
 */
public class Person4 {
    private int id;
    private String name;
    private int age;
    private  boolean man;//不能被访问

    public void setName(String name) {//对属性进行设置
        this.name = name;
    }

    public String getName() {//对属性进行获取
        return this.name;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("请输入正确的年龄");
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}
