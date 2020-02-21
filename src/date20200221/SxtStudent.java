package date20200221;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 13:40
 * description :
 */
@SxtTable("tb_student")
public class SxtStudent {

    public SxtStudent() {
    }

    @SxtField(length = 10,columnName = "age",type = "int")
    private int age;
    @SxtField(length = 10, columnName = "sname", type = "varchar")
    private String name;
    @SxtField(length = 3,columnName = "id",type = "int")
    private int id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
