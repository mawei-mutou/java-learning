package date20200321.sorm.bean;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:48
 * description :管理配置信息
 */
public class Configuration {
    //最大连接数
    private int POOL_MAX_SIZE;
    //最小连接数
    private int POOL_MIN_SIZE;
    //项目使用的查询类
    private String queryClass;
    //驱动类
    private String mysqlDriver;
    //JDBC的url
    private String jdbUrl;
    //数据库的用户名
    private String mysqlUser;
    //数据库的密码
    private String mysqlPwd;
    //正在使用那个数据库
    private String usingDB;
    //项目的源码路径（这是用来干啥的？？）
    private String srcPath;
    //扫描生成java的包（po的意思：Persistence object 持久化对象）（这又是用来干啥的？？？）
    private String poPackage;

    public Configuration() {
    }

    public Configuration(int POOL_MAX_SIZE, int POOL_MIN_SIZE, String queryClass, String mysqlDriver, String jdbUrl, String mysqlUser, String mysqlPwd, String usingDB, String srcPath, String poPackage) {
        this.POOL_MAX_SIZE = POOL_MAX_SIZE;
        this.POOL_MIN_SIZE = POOL_MIN_SIZE;
        this.queryClass = queryClass;
        this.mysqlDriver = mysqlDriver;
        this.jdbUrl = jdbUrl;
        this.mysqlUser = mysqlUser;
        this.mysqlPwd = mysqlPwd;
        this.usingDB = usingDB;
        this.srcPath = srcPath;
        this.poPackage = poPackage;
    }

    public int getPOOL_MAX_SIZE() {
        return POOL_MAX_SIZE;
    }

    public void setPOOL_MAX_SIZE(int POOL_MAX_SIZE) {
        this.POOL_MAX_SIZE = POOL_MAX_SIZE;
    }

    public int getPOOL_MIN_SIZE() {
        return POOL_MIN_SIZE;
    }

    public void setPOOL_MIN_SIZE(int POOL_MIN_SIZE) {
        this.POOL_MIN_SIZE = POOL_MIN_SIZE;
    }

    public Configuration(String queryClass, String mysqlDriver, String jdbUrl, String mysqlUser, String mysqlPwd, String usingDB, String srcPath, String poPackage) {
        this.queryClass = queryClass;
        this.mysqlDriver = mysqlDriver;
        this.jdbUrl = jdbUrl;
        this.mysqlUser = mysqlUser;
        this.mysqlPwd = mysqlPwd;
        this.usingDB = usingDB;
        this.srcPath = srcPath;
        this.poPackage = poPackage;
    }

    public String getQueryClass() {
        return queryClass;
    }

    public void setQueryClass(String queryClass) {
        this.queryClass = queryClass;
    }

    public String getMysqlDriver() {
        return mysqlDriver;
    }

    public void setMysqlDriver(String mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public String getJdbUrl() {
        return jdbUrl;
    }

    public void setJdbUrl(String jdbUrl) {
        this.jdbUrl = jdbUrl;
    }

    public String getMysqlUser() {
        return mysqlUser;
    }

    public void setMysqlUser(String mysqlUser) {
        this.mysqlUser = mysqlUser;
    }

    public String getMysqlPwd() {
        return mysqlPwd;
    }

    public void setMysqlPwd(String mysqlPwd) {
        this.mysqlPwd = mysqlPwd;
    }

    public String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }
}

