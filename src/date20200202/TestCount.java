package date20200202;

import java.io.File;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/2
 * time        : 12:57
 * description :
 */
public class TestCount {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\MrYou\\Desktop\\444");
        Count temp = new Count();
        temp.count(src);
        System.out.println(temp.getCount());
    }

}

class Count {

    private long count = 0;

    public  long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long count(File src) {
        count += src.length();
        if (null == src || !src.exists()) {
            return 0;
        } else if (src.isDirectory()) {
            for (File s : src.listFiles()) {
                count(s);
            }
        }
        return count;
    }
}
