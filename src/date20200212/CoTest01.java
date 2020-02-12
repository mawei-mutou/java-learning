package date20200212;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/12
 * time        : 18:07
 * description :管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//缓冲区
class SynContainer{
    Streamedbun[] buns = new Streamedbun[10];//存储容器
    int count = 0;//计数器

    //生产
    public synchronized void push(Streamedbun bun) {
        if (count == buns.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buns[count]=bun;
        count++;
        this.notifyAll();

    }

    //消费
    public synchronized Streamedbun pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Streamedbun bun = buns[count];
        this.notifyAll();
        return bun;
    }
}

//生产者
class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->" + i + "馒头");
            container.push(new Streamedbun(i));
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-->" + container.pop().id);
            container.pop();
        }
    }
}

//馒头
class Streamedbun {
    int id;

    public Streamedbun(int id) {
        this.id = id;
    }

}