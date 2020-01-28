package date20200119;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/19
 * time        : 11:03
 * description :
 */
public class Person4 {

    private int id;
    private String name;
    private boolean man;
    private int  age;

    public void setName(String name) {
        this.name =name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 130) {
            this.age = age;
        } else {
            System.out.println("请输入正常的年龄");
        }

    }

    public int getAge() {
        return this.age;
    }


}

