package date20200222;

import date20200217.Initial;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/22
 * time        : 21:30
 * description :动态编译
 */
public class Demon03 {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();//获取编译器
        //传入文件，动态编译
        int result = compiler.run(null, null, null, "C:\\Users\\MrYou\\Desktop\\HelloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");

        //使用输入流生成临时文件，调用动态编译str。
        String str = "public class Hi{public static void main(String[] args){System.out.println(\"hello\");}}";//这里需要用\对"进行转义
        File file = new File("src/Hi.java");
        OutputStream is2 = new BufferedOutputStream(new FileOutputStream(file));
        byte[] datas = str.getBytes();
        is2.write(datas, 0, datas.length);
        is2.flush();
        JavaCompiler compiler1 = ToolProvider.getSystemJavaCompiler();
        result = compiler1.run(null, null, null, "src/Hi.java");
        is2.close();//流未关闭之前，文件不能被删除，必须先关闭
        //file.delete();
        System.out.println(file.exists());
        System.out.println(result);


        //通过Runtime动态运行编译好的类
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp  C:/Users/MrYou/Desktop/java-learning/src Hi");
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String st = "";
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }

        //通过反射动态运行编译好的类,这种方法后面会讲
        URL[] urls = new URL[]{new URL("file:/" + "C:/Users/MrYou/Desktop/java-learning/src")};
        URLClassLoader loader = new URLClassLoader(urls);
        try {
            Class c = loader.loadClass("Hi");
            Method method = c.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{});//必须强转为Object
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
