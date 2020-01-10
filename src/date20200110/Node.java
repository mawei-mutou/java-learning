package date20200110;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/10
 * time        : 14:48
 * description :
 */
public class Node {
    Node previous;
    Node next;
    Object element;

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }
}
