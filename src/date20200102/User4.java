package date20200102;

import static java.lang.Math.PI;//这样导入则可以直接使用PI
import java.lang.Math.*;//这样导入则使用PI需要Math.PI这样使用
import java.util.*;
import java.sql.*;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import date20200101.TestConvert;
import org.w3c.dom.ls.LSOutput;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/2
 * time        : 17:25
 * description :
 */
public class User4 {
    int id;
    String name;
    String pwd;
    protected int height;//protected可以被自己、同一个包、不同的包的子类使用
    //构造方法
    public User4(int id, String name) {
        this.id =id;
        this.name = name;
    }

    public User4() {
    }

    public void testParameterTransfer01(User4 u) {
        u.name = "高小八";
    }


    public void testParameterTransfer02(User4 u) {
        u = new User4(200, "高三");
    }

    public static void main(String[] args) {
        User4 u1 = new User4(100, "高小七");//将新对象的地址赋给了u1

        //调用方法01
        u1.testParameterTransfer01(u1);//将u1的值复制给u，u重新将所指地址出的对象的name属性变为了"高小八"
        System.out.println(u1.name);
        u1.testParameterTransfer02(u1);
        /*//将u1的值复制给02方法里面的u,由于在2方法中，新建了一个对象，并将新对象的地址赋给了u，
        u的值发生了变化，因此u1所指地址处的值没有发生变化*/
        System.out.println(u1.name);
        System.out.println(PI);

        java.util.Date date = new java.util.Date();//在util和sql类里都存在date的类，它会默认使用更具体的那一个，若都没有具体到data，或者都具体到date了，还要使用则可以在date前加具体的包路径


    }

    //使用不在一个包里的类时需要导入含这个类的包
    TestConvert pp = new TestConvert();

}
