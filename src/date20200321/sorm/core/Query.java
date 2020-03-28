package date20200321.sorm.core;

import date20200321.sorm.bean.ColumnInfo;
import date20200321.sorm.bean.TableInfo;
import date20200321.sorm.utils.JDBCUtils;
import date20200321.sorm.utils.ReflectUtils;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 16:11
 * description :
 */
public abstract class Query implements Cloneable {


    //添加一个模板，使得代码灵活性更好
    public Object executeQueryTemplate(String sql, Object[] params, Class clazz, CallBack back) {
        Connection con = DBManager.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            //给sql设值
            JDBCUtils.handleParams(ps, params);
            System.out.println(ps);
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            return back.doExecute(con, ps, rs);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBManager.close(rs, ps, con);
        }
    }
    /**
     * 直接执行一个DML语句
     * sql sql语句
     * parameter 参数
     */
    public int executeDML(String sql, Object[] params){
        Connection c = DBManager.getConn();
        int count = 0;
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);
            JDBCUtils.handleParams(ps, params);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBManager.close(ps,c);
        }
        System.out.println(count+"行改变！");
        return count;
    }

    /**
     * 将一个对象存储到数据库中
     * @param object 要存储的对象
     */
    public void insert(Object object){
        //obj-->表中 insert into 表名 (id,age,name) values (?,?,?)
        Class c = object.getClass();
        List<Object> params = new ArrayList<>();//存储sql的参数值
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);//获得对应的表结构
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
        int countNotNUllField = 0;
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            String fieldName = f.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName, object);


            if (fieldValue != null) {
                countNotNUllField++;
                sql.append(fieldName + ",");
                params.add(fieldValue);
            }
        }

        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" values (");
        for (int i = 0; i < countNotNUllField; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');

        executeDML(sql.toString(), params.toArray());
    }

    /**
     * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
     * @param clazz
     * @param id
     */
    public void delete(Class clazz, Object id){
        //通过Class对象找TableInfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        //获得主键
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
        System.out.println(onlyPriKey.getName());

        String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=?";
        executeDML(sql, new Object[]{id});
    }

    /**
     * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
     * @param object
     */
    public void delete(Object object){
        Class c = object.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
        System.out.println(onlyPriKey.getName());
        //通过反射机制，调用属性对应的get方法或set方法
        Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), object);
        delete(c,priKeyValue);
    }

    /**
     * 更新对象对应的记录，并且只更新指定的字段的值
     * @param obj 所更新的对象
     * @param fieldNames 更新的属性列表
     * @return 执行sql语句后影响记录的行数
     */
    public int update(Object obj, String[] fieldNames){
        //obj(uname,pwd)-->update 表名 set uname=?,pwd=? where id=?
        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        List<Object> params = new ArrayList<>();
        ColumnInfo priKey = tableInfo.getOnlyPriKey();
        StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");
        for (String fName : fieldNames) {
            Object fValue = ReflectUtils.invokeGet(fName, obj);
            params.add(fValue);
            sql.append(fName + "=?,");
        }
        params.add(ReflectUtils.invokeGet(priKey.getName(),obj));
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append("where " + priKey.getName() + " =?");

        return executeDML(sql.toString(),params.toArray());
    }

    /**
     * 查询返回多行记录，并将每行记录封装到Clazz指定的类的对象中
     * @param sql 查询语句
     * @param clazz 封装数据的JavaBean类的Class对象
     * @param params sql的参数
     * @return 查询到的结果
     */
    public List queryRows(final String sql, final Class clazz, final Object[] params){
       return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                List list = null;
                try {
                    ResultSetMetaData metaData = rs.getMetaData();
                    //多行
                    while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        Object rowObj = clazz.newInstance();//调用javabean的无参构造器
                        //多列 select id,age,name from yao3 where id> ? and age >18
                        for (int i = 0; i < metaData.getColumnCount(); i++) {
                            String columnName = metaData.getColumnLabel(i + 1);
                            Object columnValue = rs.getObject(i + 1);

                            //调用rowObj对象的set方法，将columnValues的值设置进去
                            ReflectUtils.invokeSet(rowObj, columnName, columnValue);
                        }
                        list.add(rowObj);
                    }
                } catch (Exception e) {
                    return null;
                }
                return list;
            }
        });
    }

    /**
     * 查询返回一行记录，并将这一行记录封装到Clazz指定的类的对象中
     * @param sql 查询语句
     * @param params
     * @return
     */
    public Object queryRow(String sql, Class clazz,Object[] params) {
        List list = queryRows(sql, clazz, params);
        return (list == null && list.size() > 0) ? null : list.get(0);
    }

    /**
     * 查询返回一个值（一行一列），并将该值返回
     * @param sql sql 查询语句
     * @param params sql的参数
     * @return 查询的结果
     */
    public Object queryValues(String sql, Object[] params){
        return executeQueryTemplate(sql, params, null, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                Object values = null;
                while (true) {
                    try {
                        if (!rs.next()) break;
                        values = rs.getObject(1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                return values;
            }
        });
    }

    /**
     * 查询返回一个数字（一行一列），并将该值返回
     * @param sql 查询语句
     * @param params sql的参数
     * @return 查询的数字
     */
    public Number queryNumber(String sql, Object[] params){
        return (Number)queryValues(sql, params);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
