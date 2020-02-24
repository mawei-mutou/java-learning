package date20200223;

import javassist.*;

import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/23
 * time        : 20:16
 * description :使用Javassit构建类 属性 方法 构造器（需要导入Javassit架包）
 */
public class Demo02 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //创建类,通过类名
        CtClass cc = pool.makeClass("Emp");

        //在创建好的类中再创建属性
        CtField f1 = CtField.make("private int empno;", cc);
        CtField f2 = CtField.make("private String name;", cc);

        //将创建好的属性添加到类中去,可以初始化
        cc.addField(f1,"55");
        cc.addField(f2,"\"姚东\"");//随字符串内容初始化需要加转义字符\"

        //创建方法
        String str = "public int getEmpno(){return empno;}";
        CtMethod m1 = CtMethod.make(str, cc);
        str = "public void setEmpno(){this.empno=empno;}";
        CtMethod m2 = CtMethod.make(str, cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //创建构造器,与上面的有所不同，在CtClass[]{}里面需要添加构造器的参数类型,
        // 除了八个基本类型，别的类需要用pool.get(包名.类名)获取得到
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
        //构造构造器的方法体,一般的方法也可以这样写方法体
        constructor.setBody("{this.empno=empno;this.name=name;}");
        cc.addConstructor(constructor);
        //构建无参数构造器
        CtConstructor constructor1 = new CtConstructor(new CtClass[]{}, cc);
        cc.addConstructor(constructor1);
        //将上面写好的类写出到文件中去
        cc.writeFile("src/date20200223");
        //最后使用XJad反编译
    }
}
