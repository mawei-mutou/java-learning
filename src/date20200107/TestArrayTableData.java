package date20200107;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/7
 * time        : 13:54
 * description :
 */
public class TestArrayTableData {
    public static void main(String[] args) {
        Object[] temp1 = {1, "姚小二", 18, "初级", "2020.01.01"};
        Object[] temp2 = {1, "姚小一", 19, "中级", "2020.02.01"};
        Object[] temp3 = {1, "姚大", 120, "高级", "2020.03.01"};

        Object[][] tableData = new Object[3][];
        tableData[0] = temp1;
        tableData[1] = temp2;
        tableData[2] = temp3;

        for (Object[] a : tableData) {
            System.out.println(Arrays.toString(a));
        }
    }
}