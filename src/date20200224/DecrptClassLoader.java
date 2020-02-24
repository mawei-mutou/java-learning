package date20200224;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/24
 * time        : 20:27
 * description :
 */
public class DecrptClassLoader extends ClassLoader{
    //输入date20200224.User  -->寻找对应的类文件src/date20200224/User.class
    private String rootDir;

    public DecrptClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);//检查name对应的类是否已经加载过，若已经加载则直接返回，否则让父类去加载新的类
        if (c != null) {
            return c;
        } else {
            //获取当前对象的父类加载器
            ClassLoader parent = this.getParent();
            //让父类去加载新的类
            try {
                c = parent.loadClass(name);
            } catch (Exception e) {

            }
            if (c != null) {
                return c;
                //如果父类不能加载，这使用自定义的加载器加载，以字节数组的形式返回
            } else {
                byte[] classDate = getClassData(name);
                if (classDate == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classDate, 0, classDate.length);//从字节数组中读取数据，并且定义对应的类对象
                }
            }
        }
        return c;
    }

    //输入类名，返回相应类的字节数组
    private byte[] getClassData(String classname) {  //输入date20200224.User  -->寻找对应的类文件src/date20200224/User.class
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //replace方法将字符串中的某个字符全部替换为另一个字符
        String path = rootDir + "/" + classname.replace('.', '/') + ".class";
        try {
            is = new FileInputStream(path);//获取到对应的Class文件

            int temp = -1;
            while ((temp = is.read()) != -1) {
                baos.write(temp ^ 0xff);//对temp字节码取反
            }

            return baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
