package date20200125;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/25
 * time        : 21:36
 * description :
 */
public class TestArrayTableData {
    public static void main(String[] args) {
        Object[] emp1 = {1, "姚东", "老师", 1800};
        Object[] emp2 = {2, "姚二", "清洁", 1238};
        Object[] emp3 = {3, "姚三", "教授", 13499};
        Object[][] tableData = new Object[3][];
        tableData[0] = emp1;
        tableData[1] = emp2;
        tableData[2] = emp3;
        for (int i = 0; i < tableData.length; i++) {
            System.out.println(Arrays.toString(tableData[i]));
         }
    }
}
