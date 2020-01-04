package yzbtest.date20200103;

/**
 * 测试访问修饰符
 */
public class TestAccessToken {
    public static void main(String[] args) {
        House house = new House();
        house.getBook();
        house.getDesk();
//        house.desk=new StringBuffer();

    }
}

class House{
    private Object desk;
    private Object book;

    public House() {
        desk=new StringBuffer(1);
        book=new StringBuffer(1);
    }

    public void read(){
        System.out.println("on desk read the book!");
    }

    public Object getDesk() {
        return desk;
    }

    public Object getBook() {
        return book;
    }

}
