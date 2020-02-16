package date20200214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/14
 * time        : 19:49
 * description :
 */
public class SpiderTest02 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url = new URL("https://www.dianping.com");

        //下载资源
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        //conn.setRequestProperty("");//这里不会找
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String msg = null;
        while (null != (msg = br.readLine())) {
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理
    }

}
