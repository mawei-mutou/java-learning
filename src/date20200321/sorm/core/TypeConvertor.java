package date20200321.sorm.core;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:41
 * description :
 */
public interface TypeConvertor {

    /**
     * 将数据库数据类型转化为java的数据类型
     * @param columnType 数据库的数据类型
     * @return java数据类型
     */
    public String databaseType2JavaType(String columnType);

    /**
     * 将java数据类型转化为数据库的数据类型
     * @param javaDataType java数据类型
     * @return 数据库的数据类型
     */
    public String javaType2DatabaseType(String javaDataType);

}
