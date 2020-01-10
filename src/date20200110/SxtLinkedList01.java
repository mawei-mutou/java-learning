package date20200110;

import com.sun.org.apache.xpath.internal.objects.XObject;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/10
 * time        : 14:47
 * description :
 */
public class SxtLinkedList01 {
    private  Node first;
    private  Node last;

    private  int size;


    public Object get(int index) {
        Node temp =first;

        if (index < 0 || index > size - 1) {
            throw new RuntimeException(("索引数字不合法" + index));
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.element;
    }

    public void add(Object obj) {
        Node node = new Node(null,null, obj);
        if (first == null) {
            first = node;
            last = node;
            node.next = node.previous = node;
        } else {
            node.previous =last;
            node.next = last.next;
            last.next = node;
            last = node;
        }
        size ++;
    }


    @Override//需要讲一讲
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        sb.append(temp.element + ",");
        temp = temp.next;
        while (temp != null&&temp!=first) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static void main(String[] args) {
        SxtLinkedList01 list = new SxtLinkedList01();

        list.add("a");
        list.add("b");
        list.add("c");

        list.add("我");
        list.add("是");
        list.add("是");
        list.add("中");
        list.add("国");
        list.add("人");


        System.out.println(list);
        System.out.println(list.get(7));

    }
}
