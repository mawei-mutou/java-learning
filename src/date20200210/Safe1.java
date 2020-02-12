package date20200210;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/10
 * time        : 9:27
 * description :
 */
public class Safe1 {
    public static void main(String[] args) {
        //账户
        Account account = new Account(1000, "结婚礼金");
        Drawing you = new Drawing(account, 80, "我");
        Drawing wife = new Drawing(account, 10, "他");
        you.start();
        wife.start();
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
        if (account.money <= 0) {
            return;
        }
        synchronized (account){
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



}
