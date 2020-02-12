package date20200211;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/11
 * time        : 17:45
 * description :
 */
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c = new Web12306(4, "happy sxt");
        new Passenger(c, "一", 2).start();
        new Passenger(c, "二", 1).start();

    }
}

//顾客
class Passenger extends Thread {
    int seats;

    public Passenger(Runnable target,String name, int seats) {
        super(target,name);
        this.seats = seats;
    }
}

//火车票购票
class Web12306 implements Runnable{
    int available;
    String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }
    @Override
    public void run() {
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag) {
            System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置" + p.seats);
        }else{
            System.out.println("出票失败" + Thread.currentThread().getName() + "-->位置不够");
        }
    }

    //购票
    public synchronized boolean bookTickets(int seats) {
        System.out.println("可用位置：" + available);
        if (seats > available) {
            return false;
        } else {
            available -= seats;
            return true;
        }
    }
}

