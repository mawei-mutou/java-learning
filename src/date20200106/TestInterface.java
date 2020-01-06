package date20200106;

/**测试接口和实现类
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 16:32
 * description :
 */
public class TestInterface {
    public static void main(String[] args) {
        Volant v = new Angel();//接口不能new，但是可以作为类型，new了一个Angle类赋给Volant，固v中只有fly这个方法
        v.fly();//这是可以的
        //v.helpOthers//这是不行的，因为v属于Volant

        Honest h = new GoodMan();
        h.helpOthers();
    }
}

//飞行接口
interface Volant {
    int FLY_HEIGHT = 1000;

    void fly();
}

//善良结口
interface Honest {
    void helpOthers();
}

class Angel implements Volant, Honest {
    @Override
    public void fly() {
        System.out.println("Angle.fly");
    }

    @Override
    public void helpOthers() {
        System.out.println("Angle.helpOther");

    }//实现类可以实现多个父类的接口!
}

class GoodMan implements Honest {
    public void helpOthers() {
        System.out.println("GoodMan.helpOthers)");
    }
}

class BirdMan implements Volant{
    @Override
    public void fly() {
        System.out.println("BirdMan.fly");
    }
}
