package date20200218;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/18
 * time        : 14:06
 * description :
 */
public class Chapter1103XML01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        PHanderPerson hander = new PHanderPerson();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("date20200218/p.xml"),hander);

        List<Person> persons = hander.getPersons();
        for (Person person : persons) {
            System.out.println("名字："+person.getName()+"\t年龄："+person.getAge());
        }
    }
}

class PHanderPerson extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag;
    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null != qName) {
            tag = qName;
            if (tag.equals("person")) {
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null) {
            if (tag.equals("name")) {
                if (contents.length() > 0) {
                    person.setName(contents);
                }
            }
            if (tag.equals("age")) {
                if (contents.length() > 0){
                    person.setAge(Integer.valueOf(contents));}
                }
            }
        }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (null != qName) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Person> getPersons() {
        return persons;
    }
}
