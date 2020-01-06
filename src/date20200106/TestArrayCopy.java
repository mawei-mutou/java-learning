package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 20:48
 * description :
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        testBasicCopy2();
        extendRange();
    }

        public static void testBasicCopy(){
            String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
            String[] s2 = new String[10];
            System.arraycopy(s1, 2, s2, 6, 3);

            for (int i = 0; i < s2.length; i++) {
                System.out.println(i + "--" + s2[i]);
            }
        }
//测试从数组中删除某个元素（本质上还是数组的拷贝）
    public static void testBasicCopy2(){
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        //String[] s2 = new String[10];
        System.arraycopy(s1, 3, s1, 2, 2);
        s1[s1.length- 1] =null;
        for (int i = 0; i < s1.length; i++) {
            System.out.println(i + "--" + s1[i]);
        }
    }

    //数组的扩容(本质上是先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中去)

    public static void extendRange() {
        String[] s1 = {"aa","bb","cc"};
        String[] s2 = new String[s1.length + 10];

        System.arraycopy(s1, 0, s2, 0, s1.length);

        for (String temp : s2) {
            System.out.println(temp);

        }
    }
}
