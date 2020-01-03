package date20200103;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 17:41
 * description :
 */
public class TestPolym {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);

        Animal d = new Dog();//前面的Dog 可以换成Animal因为Dog是Animal的子类，会自动转成父类
        animalCry(d);

        Dog d3 = (Dog)d;//父转子要强制性
        animalCry(d3);

        Animal ani = (Animal)d3;//为啥还是调用的Dog里面的方法
        animalCry(ani);


        Cat c = new Cat();
        animalCry(c);

        //Cat cc = (Dog) d3;这里为啥不能转
    }

    static void animalCry(Animal a) {
        a.shout();
    }
}

//父类
class Animal {
    public void shout() {
        System.out.println("叫一声！");
    }
}


//子类继承并方法重载
class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪汪！");
    }
}

class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵！");
    }
}


