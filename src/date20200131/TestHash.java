package date20200131;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/31
 * time        : 16:12
 * description :
 */
public class TestHash {
    public static void main(String[] args) {
        int h = 66666;
        int length =(int) Math.pow(2, 8);
        System.out.println(length);

        myHash(h, length);
    }

    public static int myHash(int h, int length) {
        System.out.println(h & (length - 1));
        System.out.println(h % length);
        return h & (length - 1);
    }

}
