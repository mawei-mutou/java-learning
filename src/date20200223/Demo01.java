package date20200223;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/23
 * time        : 10:13
 * description :测试脚本引擎执行javascript
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //获取脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        //定义变量，存储到引擎上下文中
        engine.put("msg", "做事要坚持");
        String str = "var user={name:'姚东',age:18,schools:['清华大学','北京大学']};";
        str += "print(user.name);";//不能使用println

        //执行脚本
        engine.eval(str);
        //通过脚本去改变变量
        engine.eval("msg='天下无色'");
        //通过java获取
        System.out.println(engine.get("msg"));

        //定义函数
        engine.eval("function add(a,b){var sum=a+b;return sum;}");
        //取得调用接口
        Invocable jsInvoke = (Invocable) engine;//必须将engin转化为Invocable
        //执行脚本中定义的方法
        Object result=jsInvoke.invokeFunction("add", new Object[]{16,58});
        System.out.println(result);

        //导入其他的java包其他包中的java类，直接在类前加入包名
             String jsCode = "var list= java.util.Arrays.asList([\"北京尚学堂\",\"北京尚学堂\",\"北京尚学堂\"]);";
        engine.eval(jsCode);
        List<String> list2 = (List<String>) engine.get("list");
        for (String temp : list2) {
            System.out.println(temp);
        }

        //执行一个js文件（我们将a.js置于项目的src下即可）
       //
        // URL url = Demo01.class.getClassLoader().getResource("a.js");
        File file = new File("src/a.js");
        FileReader fr = new FileReader(file);
        engine.eval(fr);
        fr.close();
    }
}
