package date20200210;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/10
 * time        : 11:43
 * description :顾客买电影票
 */
public class Safe4 {
    public static void main(String[] args) {
        Cinema c = new Cinema(20, "happy sxt");
        new Thread(new Customer(c,2),"hxy").start();
        new Thread(new Customer(c,1),"yd").start();
    }
}

class Customer implements Runnable {
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag = cinema.bookTicket(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "位置-->" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName());

            }
        }
    }
}

class Cinema{
    int available;//可用位置
    String name;//名字

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    //购票
    public boolean bookTicket(int seats) {
        System.out.println("可用位置为：" + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }

}
