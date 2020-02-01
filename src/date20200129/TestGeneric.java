package date20200129;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/29
 * time        : 20:33
 * description :
 */
public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<>();
        mc.set("姚东", 0);
        mc.set("888", 1);
        String str = mc.get(0);

        System.out.println(str);
    }
}

//自定义容器
class MyCollection <E>{
    Object[] objs = new Object[5];

    public void set(E obj, int index) {
        objs[index] = obj;
    }

    public E get(int index) {
        return (E)objs[index];
    }
}
