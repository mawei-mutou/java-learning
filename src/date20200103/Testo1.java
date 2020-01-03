package date20200103;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/3
 * time        : 18:23
 * description :
 */
public class Testo1 {
    public static void main(String[] args) {
        int[] arr01 = new int [4];
        String[] arr02 = new String[9];
        Userp[] arr03 = new Userp[9];
        Userp[][] arr04 = new Userp[4][];//二维数组的一维必须给定值

        for (int i = 0; i < 4; i++) {
            arr01[i] = i;
            System.out.printf("%d\t",arr01[i]);
        }
        System.out.println("\n");
        arr03[0] = new Userp(1001, "姚小二");
        arr03[1] = new Userp(1002, "姚小三");//arr03[1]存的是对象的地址

        for (int i = 0; i < 2; i++) {
            System.out.println(arr03[i]);
            System.out.printf(arr03[i].getName()+"\t"+arr03[i].getId());
        }
    }

}

class Userp {
    private int id;
    private String name;

    public Userp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

