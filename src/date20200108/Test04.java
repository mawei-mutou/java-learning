package date20200108;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 16:42
 * description :
 */
public class Test04 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(-10);
    }
}

class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能为负数"    );
        }
        this.age =age;
    }

}


class IllegalAgeException extends RuntimeException {
    public IllegalAgeException() {

    }
}