package date20200108;

import com.sun.org.apache.xpath.internal.objects.XObject;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/8
 * time        : 19:15
 * description :
 */
public class SxtArrayList {
    private  Object[] elementData;
    private  int size;
    private static final int A = 10;

    public SxtArrayList() {
        elementData = new Object[A];
    }

    public SxtArrayList(int c) {
        elementData = new Object[c];
    }

    public void add(Object object) {
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

    public static void main(String[] args){
        SxtArrayList s1 = new SxtArrayList(30);
        s1.add("aa");
        s1.add("bb");

        System.out.println(s1);
    }

}
