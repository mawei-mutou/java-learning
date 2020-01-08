package date20200108;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 19:40
 * description :
 */
public class SxtArrayList01<E>{

    public static void main(String[] args) {
        SxtArrayList01 s1 = new SxtArrayList01(10);
        s1.add("aa");
        s1.add("bb");
        System.out.println(s1);
    }

    private  Object[] elementData;
    private  int size;
    private static final int A = 10;

    public SxtArrayList01() {
        elementData = new Object[A];
    }

    public SxtArrayList01( int c) {
        elementData = new Object[c];
    }

    public void add(E object) {
        elementData[size++] =object;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0;i<size;i++) {
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
