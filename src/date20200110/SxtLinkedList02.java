package date20200110;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/10
 * time        : 15:44
 * description :
 */
public class SxtLinkedList02 {
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


    public void remove(int index) {
        Node temp = first;
        if (temp == null) {
            throw new RuntimeException(("链表为空！"));
        }
        if (index < 0 || index > size - 1) {
            throw new RuntimeException(("索引数字不合法" + index));
        }

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node up =temp.previous;
        Node down = temp.next;
        if (last ==first) {
            temp.element = 0;
            size = 0;
        } else if (temp == first && last!=first) {
            first =temp.next;

            up.next = down;
            down.previous = up;
            size--;
        } else {
            up.next = down;
            down.previous = up;
            size--;
        }
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
        SxtLinkedList02 list = new SxtLinkedList02();

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
        list.remove(0);
        System.out.println(list);
    }
}
