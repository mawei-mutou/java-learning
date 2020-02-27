package date20200226;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/26
 * time        : 15:05
 * description :设置XML文件
 */
public class TestDOM4J02 {
    public static void main(String[] args) throws IOException {
        //通过DocumentHelper获取Document对象
        Document document = DocumentHelper.createDocument();
        //添加根元素
        Element root = document.addElement("books");
        //添加根元素的子元素
        Element book = root.addElement("book");
        //为子元素添加属性
        book.addAttribute("id", "101");
        //给book添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
        //给属性赋值
        name.addText("English");
        author.addText("姚东");
        price.addText("85");

        //写出到文件,这样写出去会在一行
        //Writer writer = new FileWriter(new File("src/date20200226/Book.xml"));
        //document.write(writer);
        //writer.close();
        //采用下面的写出为了格式美观，好读
        OutputFormat format = OutputFormat.createPrettyPrint();//创建输出格式对象
        XMLWriter writer1 = new XMLWriter(new FileWriter(new File("src/date20200226/Book.xml")),format);
        writer1.write(document);
        writer1.close();
    }
}
