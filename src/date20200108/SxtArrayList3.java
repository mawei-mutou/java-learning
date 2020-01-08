package date20200108;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 20:06
 * description :
 */
public class SxtArrayList3<E> {
    public static void main(String[] args) {
        SxtArrayList3 s1 = new SxtArrayList3(10);
        for (int i = 0; i < 20; i++) {
            s1.add("mm" + i);
        }
        s1.get(5);
        System.out.println(s1.get(50));

        System.out.println(s1);
    }

    private  Object[] elementData;
    private  int size;
    private static final int A = 10;

    public SxtArrayList3() {
        elementData = new Object[A];
    }

    public SxtArrayList3( int c) {
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

    public E get(int index) {
        return (E)elementData[index];
    }

    public void set(E element, int index) {
        if (index < elementData.length && index >= 0) {

            elementData[index] = element;
        } else {
            throw new RuntimeException("索引不合法"+index);
        }
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
