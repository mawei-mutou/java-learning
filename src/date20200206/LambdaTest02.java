package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 21:47
 * description :
 */
public class LambdaTest02 {
    public static void main(String[] args) {
        ILove love = (int a) ->{
            System.out.println("I like lambda\t" + a);
        };
        love.lambda(100);

        love = a -> System.out.println("I like lambda\t" + a);
        love.lambda(50);
    }

}

interface ILove {
    void lambda(int a);
}

class Love implements ILove {
    @Override
    public void lambda(int a) {
        System.out.println("I like lambda" + a);
    }
}
