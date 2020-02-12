package date20200209;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/9
 * time        : 14:22
 * description :
 */
public class UnsafeTest {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100, "结婚礼金");
        Drawing you = new Drawing(account, 80, "我");
        Drawing wife = new Drawing(account, 90, "他");
        you.start();
        wife.start();
    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName() + "-->账户余额为：" + account.money);
        System.out.println(this.getName() + "-->口袋钱为：" + packetTotal);
    }
}
