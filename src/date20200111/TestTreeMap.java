package date20200111;

import java.util.Map;
import java.util.TreeMap;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 14:46
 * description :
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> treemap1 = new TreeMap<>();
        treemap1.put(20, "aa");
        treemap1.put(3, "bb");
        treemap1.put(6, "cc");


        //按照key递增的方式排序
        for (Integer key : treemap1.keySet()) {
            System.out.println(key + "---" + treemap1.get(key));
        }

        Map<Emp, String> treemap2 = new TreeMap<>();
        // debug F7代表进入该方法 F8代表执行下一句 F9代表执行到下一个debug点，如无下一个debug点，则执行完。
        treemap2.put(new Emp(15, "姚三", 50000), "高级阶段");
        treemap2.put(new Emp(102, "姚二", 20000), "中级阶段");
        treemap2.put(new Emp(10, "姚大", 60000), "初级阶段");

        for (Emp key : treemap2.keySet()) {
            System.out.println(key + "---" + treemap2.get(key));
        }



    }
}
class Emp implements Comparable<Emp> {
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // 何时是升序排列 何时是降序排列
    // this代表比较的前一个元素，输入的o代表比较的后一个元素
    // 返回值1代表 this>o， 返回值-1 代表this<o，返回0代表this=o
    // 1 代表不用处理 0 代表不用处理 -1 代表要将两者调换顺序
    /*
    if(this>o){
        return 1;
    }else if(this<o){
        return -1;
    }else{
        return 0;
    }
    // 所以按照我们现在的规定，实际上是降序排序的。

     */
    @Override
    public int compareTo(Emp o) {
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else {
                return  0;
            }
        }

    }


    @Override
    public String toString(){
        return "id: " + id + "  name: " + name + " salary: " + salary;
    }
}