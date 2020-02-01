package date20200129;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/29
 * time        : 18:41
 * description :
 */
public class TestException {
    public static void main(String[] args) {
        int b = 0;
        int a;

        if (b != 0) {
            a = 1 / b;
            System.out.println(a);
        }

        String str = null;
        if (str != null) {
            System.out.println(str.length());
        }
        Animal d = new Dog();
        if (d instanceof Cat) {
            Cat c = (Cat) d;
        }
        int[] arr = new int[5];
        int a2 = 5;
        if (a2 < arr.length) {
            System.out.println(arr[a2]);
        }
    }


}

class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal {
}