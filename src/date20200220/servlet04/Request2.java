package date20200220.servlet04;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/20
 * time        : 10:08
 * description :封装请求协议：获取method uri
 * 获取参数，对参数进行封装处理
 */
public class Request2 {
    private String requestInfo;
    private String method;
    private String url;
    private String query;
    private final String CRLF = "\r\n";
    private Map<String, List<String>> parametersMap;

    public Request2(Socket client) throws IOException {
        this(client.getInputStream());//构造器的相互调用，这里调用的是Request.
    }


    public Request2(InputStream is) {
        parametersMap = new HashMap<>();
        byte[] datas = new byte[1024 * 1024];
        int len = 0;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
        convertMap(this.query);
    }

    private void parseRequestInfo() {
        System.out.println("-----分解----------");
        System.out.println("------1、获取请求方式：开头到第一个/-----");
        //1、获取/的位置
        int index = requestInfo.indexOf("/");
        int endIndex = requestInfo.indexOf("HTTP/");
        this.method = requestInfo.substring(0, index);
        this.method = this.method.trim();
        System.out.println("method:" + this.method);
        //2、获取url,可能存在请求参数，若存在参数，则？前的为url

        this.url = requestInfo.substring(index + 1, endIndex);
        int index1 = this.url.indexOf("?");
        System.out.println(index1);
        if (index1 >= 0) {//存在？，有参数
            String[] str = this.url.split("\\?");//?有特殊含义，必须转义
            this.url = str[0];
            this.query = str[1];
            System.out.println("url为：" + url);
            System.out.println("参数为：" + query);
        } else {
            System.out.println("url为：" + url);
            // System.out.println("无参数");
        }

        //  System.out.println("---3、获取请求参数：如果Get已经获取，如果是post可能在请求体中----");
        boolean isPOST = method.equals("POST");
        System.out.println(isPOST);
        if (isPOST) {
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            System.out.println("qStr为：" + qStr);
            if (qStr != null) {
                if (null == query) {
                    query = qStr;
                } else {
                    query += "&" + qStr;//字符拼接需要中间加 & 字符
                }
            }

            query = null == query ? "" : query;
            System.out.println("参数为：" + query);
        }
    }

    //使用Map对参数进行封装 ,参数格式为：flag=1&flag=2&flag=3&uname=yaodong&pwd=123456&others=
    public void convertMap(String query) {
        String[] str = query.split("&");
        for (String parameter : str) {
            String[] kv = parameter.split("=");
            kv = Arrays.copyOf(kv, 2);
            String key = kv[0];
            String value = kv[1] == null ? null : decode(kv[1], "utf-8");

            if (!parametersMap.containsKey(key)) {

                List<String> values = new ArrayList<>();
                values.add(value);
                parametersMap.put(key, values);
            } else {
                parametersMap.get(key).add(value);
            }
        }
    }

    private String decode(String value, String enc) {
        try {
            return java.net.URLDecoder.decode(value, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getParameterValues(String key) {
        List<String> values = this.parametersMap.get(key);
        if (null == values || values.size() < 1) {
            return null;
        }

        return values.toArray(new String[0]);//???
    }
    public String getParameterValue(String key) {
        String[] str = getParameterValues(key);
        if (str != null) {
            return str[0];
        }
        return null;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQuery() {
        return query;
    }
}
