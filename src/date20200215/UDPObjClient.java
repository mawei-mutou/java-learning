package date20200215;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/15
 * time        : 11:41
 * description :引用型对象：发送方
 */
public class UDPObjClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方发送中...........");
        //1、用DatagramSocket
        DatagramSocket send = new DatagramSocket(8858);
        //2、准备数据
        Person person = new Person(18, "ydhxy", 50000);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oj = new ObjectOutputStream(new BufferedOutputStream(baos));
        oj.writeUTF("今天的努力就是为了明天！");
        oj.writeInt(666);
        oj.writeObject(person);
        oj.flush();

        byte[] datas = baos.toByteArray();
        //3、封装成包
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 8989));
        //4、发送数据
        send.send(packet);
        //5、关闭资源
        send.close();
    }
}

class Person implements Serializable {

    private int age;
    private String name;
    private double salary;

    public Person(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
