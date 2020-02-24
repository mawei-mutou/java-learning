package date20200223;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/23
 * time        : 21:18
 * description :测试javassist的API
 */
public class Demo03 {

    //处理类的基本用法
    public static void test01() throws NotFoundException, IOException, CannotCompileException {
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //获取已经存在的类
        CtClass cc = pool.get("date20200223.Emp");

        byte[] datas = cc.toBytecode();
        System.out.println(Arrays.toString(datas));
        System.out.println(cc.getName());//获取类名
        System.out.println(cc.getSimpleName());//获取简要类名
        System.out.println(cc.getSuperclass());//获取父类
        System.out.println(cc.getClass());//获取类
        System.out.println(cc.getInterfaces());//获取接口

    }

    //测试产生新的方法
    public static void test02() throws Exception {

        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.getCtClass("date20200223.Emp");

        //将被冻结的类解冻，才能进行操作
        if(cc.isFrozen()){
            cc.defrost();
        }
        //构建新方法
        //CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
        CtMethod m1=CtMethod.make("public int add(int a,int b){return a+b;}", cc);

        CtMethod m2 = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, cc);

        m2.setModifiers(Modifier.PUBLIC);
        //$1表示第一个参数，$2表示第二个参数
        m2.setBody("return $1+$2;");
        cc.addMethod(m2);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        Object result = method.invoke(obj, 200, 200);
        System.out.println(result);
    }

    //获取已有的方法，对它进行修改
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.getCtClass("date20200223.Emp");
        //将被冻结的类解冻，才能进行操作
        if(cc.isFrozen()){
            cc.defrost();
        }
        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        cm.insertAt(15,"System.out.println(\"任意修改！！\");");
        cm.insertAfter("System.out.println(\"end!!!\");");


        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method m = clazz.getDeclaredMethod("sayHello", int.class);
        m.invoke(obj, 888);
    }

    //对属性进行操作
    public static void test04() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.getCtClass("date20200223.Emp");
        //将被冻结的类解冻，才能进行操作
        if(cc.isFrozen()){
            cc.defrost();
        }
        CtField f = new CtField(CtClass.intType, "salary", cc);
        f.setModifiers(Modifier.PRIVATE);
        cc.addField(f, "100");

        cc.addMethod(CtNewMethod.getter("getSalary", f));
        cc.addMethod(CtNewMethod.getter("setSalary", f));
    }
    public static void main(String[] args) throws Exception {
//        test01();
//        test02();
        test03();
        test04();
    }
}
