package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 21:38
 * description :
 */
public class LambdaTest01 {

    //静态内部类
    static class Like1 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {

        //局部内部类
        class Like2 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        ILike like = new Like();
        like.lambda();

        like = new Like1();
        like.lambda();

        like = new Like2();
        like.lambda();

        //匿名内部类
        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        //Lambda表达式
        like = () -> System.out.println("i like lambda5");
        like.lambda();
    }
}

interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda!");
    }
}
