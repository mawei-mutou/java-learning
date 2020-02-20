package date20200219.review;


import date20200218.LoginServlet;
import date20200219.Mapping;
import date20200219.Servlet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 9:31
 * description :
 */
public class a2 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        PHander hander = new PHander();
        //parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200218/web.xml"),hander);
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200218/web.xml"), hander);

        //parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("src/date20200218/web.xml"), hander);


        List<Mapping> mappings = hander.getMappings();
        List<Servlet> servlets = hander.getServlets();

        WebUtil web = new WebUtil(mappings, servlets);
//        Map<String, String> map = web.getMap();
//        Map<String, String> servlet = web.getServlet();
        String url = web.getCls("/g");
        System.out.println(url);
        Class cls = Class.forName(url);
        LoginServlet ppp = (LoginServlet) cls.getConstructor().newInstance();
        System.out.println(ppp);

        for (Mapping temp : mappings) {
            for (String patterns : temp.getPatterns()) {
                System.out.println(temp.getName()+"-->"+patterns);
            }
        }
        for (Servlet temp : servlets) {
            System.out.println(temp.getName()+"-->"+temp.getCls());
        }

    }


}

class PHander extends DefaultHandler {
    private List<Servlet> servlets;
    private List<Mapping> mappings;
    private Servlet servlet;
    private Mapping mapping;
    private String tag;
    private boolean isMapping=false;
    @Override
    public void startDocument() throws SAXException {
        servlets = new ArrayList<>();
        mappings = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;
            if (tag.equals("servlet")) {
                servlet = new Servlet();
                isMapping =false;
            }
            if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping =true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null) {
            if (isMapping) {
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                }
                if (tag.equals("url-pattern")) {
                    mapping.addPatterns(contents);
                }
            } else {
                if (tag.equals("servlet-name")) {
                    servlet.setName(contents);
                }
                if (tag.equals("servlet-class")) {
                    servlet.setCls(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("servlet")) {
                servlets.add(servlet);
            }
            if (qName.equals("servlet-mapping")) {
                mappings.add(mapping);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    public List<Servlet> getServlets() {
        return servlets;
    }
}