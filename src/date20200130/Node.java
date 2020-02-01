package date20200130;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/30
 * time        : 17:18
 * description :
 */
public class Node {
    Node previous;
    Node next;
    Object element;

    public Node(Object element) {
        this.element = element;
    }
}
