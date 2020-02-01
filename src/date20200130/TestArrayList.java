package date20200130;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/30
 * time        : 12:25
 * description :
 */
public class TestArrayList<E> {
    private Object[] elementData;
    private int size;
    private static final int DEALT_CAPACITY = 10;


    public TestArrayList() {
        elementData = new Object[DEALT_CAPACITY];
    }

    public TestArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E element) {
        if (size == elementData.length) {
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;


        }
        elementData[size++] = element;
    }

    public E get(int index) {
        return (E)elementData[index];
    }

    public void set(E element, int index) {
        elementData[index]=element;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i=0;i<size;i++) {
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            int numMoved = elementData.length - i - 1;

            if (element.equals(get(i))) {
                System.arraycopy(elementData, i + 1, elementData, i, elementData.length - i - 1);
                elementData[size - 1] = null;
                size--;
            }
        }
    }

    public static void main(String[] args) {
        TestArrayList<String> s1 = new TestArrayList();
        for (int i = 0; i < 14; i++) {
            s1.add("wo"+i);
        }

        System.out.println(s1.elementData.length);
        System.out.println(s1);
        s1.set("我爱你",13);
        System.out.println(s1.get(13));
        System.out.println(s1);

        s1.remove("wo8");
        System.out.println(s1);

    }
}
