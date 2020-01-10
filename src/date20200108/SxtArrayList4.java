package date20200108;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 20:22
 * description :
 */
public class SxtArrayList4 <E>{
    public static void main(String[] args) {
        SxtArrayList4 s1 = new SxtArrayList4(10);
        for (int i = 0; i < 20; i++) {
            s1.add("mm" + i);
        }
        s1.get(5);
        System.out.println(s1.get(5
        ));

        System.out.println(s1);

        s1.remove(5);
        System.out.println(s1);
    }

    private  Object[] elementData;
    private  int size;
    private static final int A = 10;

    public SxtArrayList4() {
        elementData = new Object[A];
    }

    public SxtArrayList4( int c) {
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


    public void remove(E element) {
        //将element和所有的元素进行比较，获得第一个为true的返回

        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                //将该处元素移除
                remove(i);
            }
        }
    }


    public void remove(int index) {

        int numMoved =elementData.length-index-1;
        if (numMoved > 0) {

            System.arraycopy(elementData, index + 1, elementData, index, numMoved);        }

        elementData[size-1] =null;
        size--;
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
