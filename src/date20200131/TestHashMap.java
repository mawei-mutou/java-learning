package date20200131;
/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/31
 * time        : 17:43
 * description :
 */
public class TestHashMap<K,V>{
    Node[] table;
    int size;

    public static void main(String[] args) {
        TestHashMap<Integer,String>m1 = new TestHashMap();
        m1.put(1, "11");
        m1.put(2, "想");
        m1.put(3, "你");
        m1.put(4, "了");
        m1.put(1, "我");

        m1.put(53, "媳");
        //m1.put(69, "妇");
        m1.put(85, "儿");
        System.out.println(m1);

        System.out.println(m1.get(69));

    }
    public TestHashMap() {
        table = new Node[16];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];
            while (temp != null) {
                sb.append(temp.value);
                temp = temp.next;
            }
        }
        sb.append(']');
        return sb.toString();

    }

    public void put(K key, V value) {
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        //System.out.println(newNode.hash);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        if (temp == null) {
            table[newNode.hash] = newNode;
            size++;
//            temp.hash = newNode.hash;
//            temp.value = newNode.value;
//            temp.key = newNode.key;
//            temp.next = newNode.next;
        } else {
            while (temp.next != null) {
                if (temp.key.equals(key)) {
                    System.out.println("key重复！");
                    temp.value = value;
                    break;
                }
                temp = temp.next;
            }

            if (temp.key.equals(key)) {
                System.out.println("key重复！");
                temp.value = value;
            } else if(temp.next == null) {
                temp.next = newNode;
                size++;
            }
        }
    }

    public int myHash(int v, int length) {
        return v & (length - 1);
    }

    public V get(K key) {
        int hash = myHash(key.hashCode(), table.length);
        Node temp = table[hash];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return (V)temp.value;
            }
            temp = temp.next;
        }
        return (V)"没有对应key";
    }
}
