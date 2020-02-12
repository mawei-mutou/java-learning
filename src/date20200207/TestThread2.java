package date20200207;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/7
 * time        : 8:34
 * description :
 */
public class TestThread2 extends Thread {
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoad downLoad = new WebDownLoad();
        downLoad.download(url, name);
    }
    public static void main(String[] args) {
        TestThread2 tt1 = new TestThread2("https://www.quanjing.com/imgbuy/QJ6675734390.html\n","picture1.jpg");
        TestThread2 tt2 = new TestThread2("https://www.quanjing.com/imgbuy/QJ6469520651.html\n","picture2.jpg");
        //TestThread2 tt3 = new TestThread2("https://www.quanjing.com/imgbuy/QJ6675734390.html\n","picture1");

        tt1.start();
        tt2.start();
    }
}
