package date20200108;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 19:46
 * description :
 */
public class SxtArrayList2<E> {
    public static void main(String[] args) {
        SxtArrayList2 s1 = new SxtArrayList2(10);
        for (int i = 0; i < 20; i++) {
            s1.add("mm" + i);
        }
        System.out.println(s1);
    }

    private  Object[] elementData;
    private  int size;
    private static final int A = 10;

    public SxtArrayList2() {
        elementData = new Object[A];
    }

    public SxtArrayList2( int c) {
        elementData = new Object[c];
    }

    public void add(E object) {

        //什么时候需要扩容
        if (size == elementData.length) {
            //如何扩容
            Object[] newArray = new Object[elementData.length +( elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);

            elementData =newArray;
        }
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
