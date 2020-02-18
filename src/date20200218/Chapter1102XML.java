package date20200218;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/18
 * time        : 11:55
 * description :
 */
public class Chapter1102XML {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory1 = SAXParserFactory.newInstance();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂中获取解析器
        SAXParser parser2 = factory1.newSAXParser();
        SAXParser parser = factory.newSAXParser();
        //3、编写处理器
        //4、加载文档Document注册处理器
        PHander hander = new PHander();
        //5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200218/p.xml"), hander);
    }
}

class PHander extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始");
    }

    @Override//只关注qname
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();//trim()去掉字符串首尾的空白字符
        if (contents.length() > 0) {
            System.out.println("内容为："+contents);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束");
    }
}
