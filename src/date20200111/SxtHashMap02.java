package date20200111;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 13:50
 * description :实现toString方法
 */
public class SxtHashMap02<K,V> {
    Node2[] table;//位桶数组
    int size;

    public SxtHashMap02() {
        table = new Node2[16];
    }


    public V get(K key) {
        int hash = myHash(key.hashCode(), table.length);
        V value = null;
        if (table[hash] != null) {
            Node2 temp = table[hash];

            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = (V) temp.value;
                    break;
                } else {
                    temp =temp.next;
                }
            }
        }
        return  value;
    }

    public void put(K key, V value) {
        Node2 newNode = new Node2();
        newNode.hash =myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value =value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];
        Node2 iterLast = null;
        boolean keyRepeat =false;
        if (temp == null) {
            table[newNode.hash] = newNode;

            size++;
        } else {
            while (temp != null) {
                if (temp.key.equals(key)) {
                    System.out.println("key重复了");

                    keyRepeat =true;
                    temp.value= value;
                    break;
                } else {
                    iterLast =temp;
                    temp = temp.next;
                }
            }

            if (!keyRepeat) {

                iterLast.next = newNode;
                size++;
            }
        }


    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < table.length; i++) {
            Node2 temp = table[i];
            while (temp != null) {
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }

        sb.setCharAt(sb.length()- 1, '}');
        return sb.toString();
    }
    public static int myHash(int v, int length) {
//        System.out.println("hash in myHash:"+(v&(length-1)));
//        System.out.println("hash in myHash:"+(v%(length)));
        return v & (length - 1);
    }

    public static void main(String[] args) {
        SxtHashMap02<Integer,String> m = new SxtHashMap02();
        m.put(10, "aa");
        m.put(20, "bb");

        m.put(30, "cc");
        m.put(53, "gg");
        m.put(69, "hh");
        m.put(85, "kk");

        //m.put(20, "ssss");

        System.out.println(m);

        System.out.println(m.get(69));

//        for (int i = 10; i < 100; i++) {
//            System.out.println(i+"---"+myHash(i,16));
//        }
    }


}
