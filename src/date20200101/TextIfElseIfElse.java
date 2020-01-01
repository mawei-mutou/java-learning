package date20200101;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/1
 * time        : 17:39
 * description :
 */
public class TextIfElseIfElse {
    public static void main(String[] args) {
        int age =(int)(100*Math.random());
        System.out.println("年龄是" + age + ", 属于");
        if (age < 15) {
            System.out.println("儿童，喜欢玩");
        } else if (age < 25) {
            System.out.println("青年， 要学习");
        } else if (age < 45) {
            System.out.println("中年， 要工作");
        } else if (age < 65) {
            System.out.println("中老年， 要运动");
        } else if (age < 85) {
            System.out.println("老年， 要补钙");
        } else {
            System.out.println("老寿星， 古来稀");

        }
    }
}
