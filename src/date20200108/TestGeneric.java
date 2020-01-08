package date20200108;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 17:19
 * description :
 */
public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<>();
        mc.set("yaodong", 0);
        String b = mc.get(0);
    }
}

class MyCollection<E>{
    Object[] objs = new Object[5];

    public void set(E e, int index) {
        objs[index] = e;
    }

    public E get(int index) {
        return (E) objs[index];
    }
}
