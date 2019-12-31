package date1231.Package1;


/**
 * created with IntelliJ IDEA
 * author      : yaodong
 * date        : 2019/12/31
 * time        : 09:43
 * description :练习
 */
public class TestOne {
    int a;//成员变量不初始化则会自动赋默认值，从属于变量
    static int size;//静态变量，从属于类
    public static void main(String[] args) {
        int a123 = 1;
        //int 123abc = 2;不能以字母开头；
        int $a = 3;
        int _abc = 5;
        int 年龄 = 18;//可以使用字母，但是不建议；

        //int class = 12;//关键字不能作为标识符
        int age;
            age = 18;
        int salary = 300;
        int gao = 13;
        System.out.println(gao);
        //变量只有先声明并初始化后才能使用；
        {
            int i = 0;
            int j = i + 1;//局部变量必须先声明并初始化才能使用
        }
        }

}
