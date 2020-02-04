package date20200204;

import java.io.*;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 21:19
 * description :文件的对象流
 */
public class IOTest07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出-->序列化
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.txt")));

        oos.writeUTF("编码辛酸泪");
        oos.writeInt(56);
        oos.writeBoolean(false);
        oos.writeChar('a');
        oos.writeObject("谁解其中味");
        oos.writeObject(new Date());
        Person2 person = new Person2("马云", 85, 30000);
        oos.writeObject(person);
        oos.flush();
        oos.close();
        //读入-->反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.txt")));

        String str = dis.readUTF();
        int aa = dis.readInt();
        boolean f = dis.readBoolean();
        char p = dis.readChar();
        Object pp = dis.readObject();
        Object date = dis.readObject();
        Object person2 = dis.readObject();
        dis.close();
        if (pp instanceof String) {
            System.out.println((String) pp);
        }
        if (date instanceof Date) {
            System.out.println((Date) date);
        }
        if (person2 instanceof Person2) {
            Person2 man = (Person2) person2;
            System.out.println("姓名：" + man.getName() + "\t年龄：" + man.getAge() + "\t工资：" + man.getSalary());
        }

    }
}