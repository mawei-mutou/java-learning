package date20200227;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/27
 * time        : 13:45
 * description :使用正则表达式进行网络爬虫
 */
public class Demo04 {
    public static String getURLContents(String urlStr,String charset)throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(urlStr);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
        //String
        String temp = "";
        while ((temp = br.readLine()) != null) {
            sb.append(temp).append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        String str=getURLContents("http://www.163.com","gbk");
        Pattern p = Pattern.compile("href=\"([\\w\\s./:]+?)\"");
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
