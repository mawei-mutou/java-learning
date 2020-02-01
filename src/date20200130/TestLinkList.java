package date20200130;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/30
 * time        : 17:19
 * description :
 */
public class TestLinkList {
    private Node first;
    private Node last;

    private int size;

    public void remove(int index) {
        Node temp = first;
        Node previous = first;
        int count = 1;
        if (index == 1) {
            first = first.next;
            first.previous = null;
        } else {
            for (int i = 1; count < index + 1; i++) {

                temp = first.next;
                previous = temp.previous;
                previous.next = temp.next;
                temp.next.previous = previous;
            }
        }


    }

    public void add(Object object) {
        Node node = new Node(object);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            node.next=last.next;
            node.previous=last;
            last.next=node;
            last = node;
            size++;
        }
    }


    public Object get(int index) {
        Node temp = first;
        int count=1;
        if (index < 0 || index > size+1) {
            throw new RuntimeException("索引数字不合法：" + index);
        } else {
            for (int i = 1; count < index + 1; i++) {
                if (i == 1) {
                    temp = first;
                    count++;
                } else {
                    temp = temp.next;
                    count++;
                }
            }
        }


        return temp.element;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node temp = first;
        while (temp != null) {
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        TestLinkList list = new TestLinkList();
        list.add("爱你❤❤❤");
        list.add("媳妇儿😊😊😊");
        System.out.println("元素个数为："+list.size);
        System.out.println(list);

        System.out.println(list.get(2));
        System.out.println(list.get(1));

    }
}