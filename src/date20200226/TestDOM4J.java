package date20200226;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/26
 * time        : 13:53
 * description :读取XML文件
 */
public class TestDOM4J {
    public static void main(String[] args) throws DocumentException {
        //首先获取SAXreader对象或者DOMreader对象，读取Xml文件
        SAXReader saxReader = new SAXReader();
        //读取XML文件，获取document对象
        Document document = saxReader.read(new File("src/date20200226/Student02.xml"));
        //获取根元素
        Element root = document.getRootElement();
        System.out.println(root.getName());
        //获取根元素下面的所有子元素，使用迭代器Iterator
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            //去除元素
            Element e = iterator.next();
            System.out.println(e.getName());
            //获取id属性,如果有多个也可以使用迭代器
            Attribute d = e.attribute("id");
            System.out.println(d.getName() + "=" + d.getValue());
            //获取student的子元素
            Element name = e.element("name");
            Element course = e.element("course");
            Element score = e.element("score");
            System.out.println(name.getName() + "=" + name.getStringValue());
            System.out.println(course.getName() + "=" + course.getStringValue());
            System.out.println(score.getName() + "=" + score.getStringValue());
        }

    }
}
