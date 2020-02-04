package date20200204;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 11:22
 * description :
 */
public class DecorateTest02 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink milk = new Mile(coffee);
        System.out.println(milk.info()+"-->"+milk.cost());

        Drink suger = new Suger(coffee);
        System.out.println(suger.info() + "-->" + suger.cost());
        suger = new Suger(milk);
        System.out.println(suger.info() + "-->" + suger.cost());

    }
}

//1、抽象组件：需要被装饰的抽象对象
interface Drink {
    public double cost();

    public String info();
}

//2、具体组件：需要装饰的对象
 class Coffee implements Drink {
    private String name = "原味咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

//3、抽象装饰类
abstract class Decorate implements Drink{
    private Drink drink;


    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }
}

//4、具体装饰类
class Mile extends Decorate {
    public Mile(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }
}
class Suger extends Decorate {
    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加入了蔗糖";
    }
}