package date20200321.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:49
 * description :
 */
public class TableInfo {

    //表名
    private String tname;

    //所有字段的信息
    private Map<String, ColumnInfo> columns;

    //唯一主键（目前只处理表中只有一个主键的情况）
    private ColumnInfo onlyPriKey;

    //如果联合主键，则在这里存储
    private List<ColumnInfo> priKeys;

    public TableInfo(String tname, Map<String, ColumnInfo> colums, ColumnInfo onlyPrikey) {
        this.tname = tname;
        this.columns = colums;
        this.onlyPriKey = onlyPrikey;
    }

    public TableInfo(String tname, Map<String, ColumnInfo> colums, List<ColumnInfo> priKeys) {
        this.tname = tname;
        this.columns = colums;
        this.priKeys = priKeys;
    }

    public TableInfo() {
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> colums) {
        this.columns = colums;
    }

    public ColumnInfo getOnlyPriKey() {
        return onlyPriKey;
    }

    public void setOnlyPriKey(ColumnInfo onlyPrikey) {
        this.onlyPriKey = onlyPrikey;
    }

    public List<ColumnInfo> getPriKeys() {
        return priKeys;
    }

    public void setPriKeys(List<ColumnInfo> priKeys) {
        this.priKeys = priKeys;
    }
}
