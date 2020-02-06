package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 21:51
 * description :
 */
public class LambdaTest03 {
    public static void main(String[] args) {
        IInterest interest = (int a, int b) -> {
            System.out.println("I like lambda" + (a + b));
            return a + b;
        };
        interest.lambda(100, 80);

        interest = (a, b) ->{
            System.out.println("I like lambda" + (a + b));
            return a+b;
        };
        interest.lambda(80, 25);

        interest = (a, b) -> a + b;
        System.out.println(interest.lambda(8, 2));
    }

}

interface IInterest {
    public int lambda(int a, int b);
}

class Interest implements IInterest{

    @Override
    public int lambda(int a, int b) {
        System.out.println("I like lambda" + (a + b));
        return a + b;
    }
}
