package date20200218;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/18
 * time        : 15:39
 * description :
 */
public class Chapter1104XML02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        WebHander hander = new WebHander();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200218/web.xml"), hander);

        List<Mapping> mapps = hander.getMapps();
        List<Servlet> servlets = hander.getServlets();

        for (Mapping mapping : mapps) {
            Set<String> str=mapping.getPatterns();
            for (String temp : str) {
                System.out.println(mapping.getName()+"\t"+temp);
            }
        }

        for (Servlet servlet : servlets) {
            System.out.println(servlet.getName()+"\t"+servlet.getCls());
        }

    }
}

class WebHander extends DefaultHandler {
    private List<Mapping> mapps;
    private Mapping mapping;
    private List<Servlet> servlets;
    private Servlet servlet;
    private String tag;
    private boolean isMapping = false;


    @Override
    public void startDocument() throws SAXException {
        mapps = new ArrayList<>();
        servlets = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;
            if (tag.equals("servlet")) {
                servlet = new Servlet();
                isMapping = false;
            }
            if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (isMapping) {//为Mapping
            if (tag != null) {
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                }
                if (tag.equals(("url-pattern"))) {
                    mapping.addMapping(contents);
                }
            }
        } else {//Servlet
            if (tag != null) {
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
        if (null != qName) {
            if (qName.equals("servlet")) {
                servlets.add(servlet);
            }
            if (qName.equals("servlet-mapping")) {
                mapps.add(mapping);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Mapping> getMapps() {
        return mapps;
    }

    public List<Servlet> getServlets() {
        return servlets;
    }
}
