package date20200224;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/24
 * time        : 19:17
 * description :
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader=new FileSystemClassLoader("C:/Users/MrYou/Desktop/java-learning/src");
        FileSystemClassLoader loader2=new FileSystemClassLoader("C:/Users/MrYou/Desktop/java-learning/src");

        Class<?> c = loader.loadClass("date20200224.Demo1");
        Class<?> c1 = loader.loadClass("date20200224.Demo1");
        Class<?> c2 = loader2.loadClass("date20200224.Demo1");


        System.out.println(c.hashCode());
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c.getClassLoader());
        System.out.println(c2.getClassLoader());

    }
}
