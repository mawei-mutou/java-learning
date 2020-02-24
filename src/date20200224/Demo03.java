package date20200224;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/24
 * time        : 20:27
 * description :
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        DecrptClassLoader loader=new DecrptClassLoader("C:/Users/MrYou/Desktop/新建文件夹/temp");
        DecrptClassLoader loader2=new DecrptClassLoader("C:/Users/MrYou/Desktop/新建文件夹/temp");

        Class<?> c = loader.loadClass("HelloWorld");
        Class<?> c1 = loader.loadClass("HelloWorld");
        Class<?> c2 = loader2.loadClass("HelloWorld");
        System.out.println(c);
    }
}
