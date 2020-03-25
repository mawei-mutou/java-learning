package date20200321.sorm.utils;

import date20200321.sorm.bean.ColumnInfo;
import date20200321.sorm.bean.JavaFieldGetSet;
import date20200321.sorm.bean.TableInfo;
import date20200321.sorm.core.DBManager;
import date20200321.sorm.core.MySqlTypeConvertor;
import date20200321.sorm.core.TableContext;
import date20200321.sorm.core.TypeConvertor;
import javafx.scene.control.Tab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:45
 * description :封装了Java文件（源代码）常用的操作
 */
public class JavaFileUtils {

    /**
     * 根据字段信息生成java属性信息，如：varchar username --> private String username;以及相应的set和get方法源码
     * @param column 字段信息
     * @param convertor 类型转化器
     * @return java属性和set/get方法
     */
    public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
        JavaFieldGetSet jfgs = new JavaFieldGetSet();
        String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
        jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

        //public String getUsername(){return username;}
        //生成get方法
        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + "(){\n");
        getSrc.append("\t\treturn " + column.getName() + ";\n");
        getSrc.append("\t}\n");
        jfgs.setGetInfo(getSrc.toString());

        //生成set方法。public void setUsername(String username){this.username=username;}
        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
        setSrc.append(javaFieldType + " " + column.getName() + "){\n");
        setSrc.append("\t\tthis." + column.getName() + " = "+column.getName()+";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());
        return jfgs;
    }

    /**
     * 根据表信息生成java类的源代码
     * @param tableInfo 表信息
     * @param convertor 数据类型转化器
     * @return java 类的源代码
     */
    public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {
        Map<String, ColumnInfo> columns = tableInfo.getColumns();//获取到所有的列信息
        List<JavaFieldGetSet> javaFields = new ArrayList<>();
        for (ColumnInfo c : columns.values()) {
            javaFields.add(createFieldGetSetSRC(c, convertor));
        }
        StringBuilder src = new StringBuilder();
        //生成package信息
        src.append("package " + DBManager.getConf().getPoPackage() + ";\n\n");

        //生成import语句
        src.append("import java.sql.*;\n");
        src.append("import java.util.*;\n\n");

        //生成类声明语句
        src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + " {\n\n");

        //生成属性列表
        for (JavaFieldGetSet f : javaFields) {
            src.append(f.getFieldInfo());
        }

        src.append("\n\n");

        //生成get方法列表
        for (JavaFieldGetSet f : javaFields) {
            src.append(f.getGetInfo());
        }

        //生成set方法列表
        for (JavaFieldGetSet f : javaFields) {
            src.append(f.getSetInfo());
        }

        //生成类结束
        src.append("}\n");

        return src.toString();
    }


    //通过流把生成的java代码写到相应的文件里面
    public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
        String src = createJavaSrc(tableInfo, convertor);
        String poPath = DBManager.getConf().getSrcPath() + "\\";

        String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
        File f = new File(poPath + packagePath);

        if (!f.exists()) {
            f.mkdirs();
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()+ "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java"));
            bw.write(src);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
