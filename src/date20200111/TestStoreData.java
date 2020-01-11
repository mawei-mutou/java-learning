package date20200111;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 19:56
 * description :
 */
public class TestStoreData {
    public static void main(String[] args) {
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 101);
        row1.put("name", "张三");
        row1.put("salary", 50000);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 102);
        row2.put("name", "王五");
        row2.put("salary", 60000);

        Map<String, Object> row3 = new HashMap<>();
        row3.put("id", 103);
        row3.put("name", "赵四");
        row3.put("salary", 6000);


        List<Map<String, Object>> table = new ArrayList<>();

        table.add(row1);
        table.add(row2);
        table.add(row3);

        for (Map<String, Object> temp : table) {
            Set<String> set = temp.keySet();
            for (String key : set) {
                System.out.print(key + "\t"+temp.get(key)+"\t");
            }
            System.out.println();
        }

    }
}
