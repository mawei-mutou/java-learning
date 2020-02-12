package date20200211;

import java.util.ArrayList;
import java.util.List;

public class Safe5 {
    public static void main(String[] args) {

        //可用位置
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);

        List<Integer> seat1 = new ArrayList<>();
        seat1.add(1);
        seat1.add(2);

        List<Integer> seat2 = new ArrayList<>();
        seat2.add(4);
        seat2.add(5);
        seat2.add(6);
        Cinema2 c = new Cinema2(available, "happy sxt");
        new Thread(new Customer2(c,seat1),"hxy").start();
        new Thread(new Customer2(c,seat2),"yd").start();
    }
}

class Customer2 implements Runnable {
    Cinema2 cinema;
    List<Integer> seats;

    public Customer2(Cinema2 cinema, List<Integer> seats) {
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

class Cinema2{
    List<Integer> available;//可用位置
    String name;//名字

    public Cinema2(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    //购票
    public boolean bookTicket(List<Integer> seats) {
        System.out.println("可用位置为：" + available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);

        //相减
        copy.removeAll(seats);
        //判断大小
        if (available.size() - copy.size() != seats.size()) {
            return false;
        }

        available = copy;
        return true;
    }
}