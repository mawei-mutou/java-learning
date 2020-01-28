package date20200119;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/19
 * time        : 20:13
 * description :
 */
public class TestPolym {
    public static void main(String[] args) {
        Animal a =new Animal();
        animalCry(a);
        Dog d= new Dog();
        animalCry(d);
        Cat c = new Cat();
        animalCry(c);
    }

    static void animalCry(Animal a) {
        a.shout();
    }
}


class Animal {
    public void shout() {
        System.out.println("叫一声");

    }
}

class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪汪");

    }
}


class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵");
    }
}
