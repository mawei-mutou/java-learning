package date20200220.servlet04;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 18:00
 * description :
 */
public class WebHander2 extends DefaultHandler {
    private List<Mapping> mapps;
    private Mapping mapping;
    private List<Servlet2> servlets;
    private Servlet2 servlet;
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
                servlet = new Servlet2();
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

    public List<Servlet2> getServlets() {
        return servlets;
    }
}

