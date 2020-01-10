package date20200110;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/10
 * time        : 19:42
 * description :
 */
public class SxtHsshMap1 {
    Node2[] table;//位桶数组
    int size;

    public SxtHsshMap1() {
        table = new Node2[16];
    }

    public void put(Object key, Object value) {
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
            }
        }


    }

    public static int myHash(int v, int length) {
//        System.out.println("hash in myHash:"+(v&(length-1)));
//        System.out.println("hash in myHash:"+(v%(length)));
        return v & (length - 1);
    }

    public static void main(String[] args) {
        SxtHsshMap1 m = new SxtHsshMap1();
        m.put(10, "aa");
       m.put(20, "bb");
       m.put(30, "cc");
        m.put(20, "ssss");

        System.out.println(m);
        for (int i = 10; i < 100; i++) {
            System.out.println(i+"---"+myHash(i,16));
        }
    }

}
