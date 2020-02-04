package date20200204;

import java.io.*;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 20:39
 * description :字节数组的序列化和反序列化（对象流）
 */
public class IOTest06 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出-->序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeUTF("编码辛酸泪");
        oos.writeInt(56);
        oos.writeBoolean(false);
        oos.writeChar('a');
        oos.writeObject("谁解其中味");
        oos.writeObject(new Date());
        Person2 person = new Person2("马云", 85, 30000);
        oos.writeObject(person);
        oos.flush();
        byte[] data = baos.toByteArray();
        //读入-->反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
        String str = dis.readUTF();
        int aa = dis.readInt();
        boolean f = dis.readBoolean();
        char p = dis.readChar();
        Object pp = dis.readObject();
        Object date = dis.readObject();
        Object person2 = dis.readObject();
        if (pp instanceof String) {
            System.out.println((String)pp);
        }
        if (date instanceof Date) {
            System.out.println((Date) date);
        }
        if (person2 instanceof Person2) {
            Person2 man = (Person2) person2;
            System.out.println("姓名："+man.getName()+"\t年龄："+man.getAge()+"\t工资："+man.getSalary());
        }

    }


}

class Person2 implements Serializable {
    private  transient String name;
    private int age;
    private double salary;

    public Person2() {
    }

    public Person2(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

