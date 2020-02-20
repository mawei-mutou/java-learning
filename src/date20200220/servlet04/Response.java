package date20200220.servlet04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 16:32
 * description :
 */
public class Response {
    private final String BLANK = " ";
    private final String CRLF = "\r\n";
    private BufferedWriter bw;
    private StringBuilder response;
    //正文
    private StringBuilder content;
    //协议头
    private StringBuilder headInfo;
    private int len;
    public Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
        response = new StringBuilder();
        len = 0;
    }
    public Response(Socket client) {
        this();//它的作用
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    //动态添加内容(流模式)
    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    public Response println(String info) {
        content.append(info).append(CRLF);

        len += (info + CRLF).getBytes().length;
        return this;
    }

    //推送响应信息
    public void pushToBrowser(int code) throws IOException {
        if (null == headInfo) {
            code = 505;
        }
        createHeadInfo(code);
        response.append(headInfo).append(content);
        bw.write(response.toString());
        bw.flush();
    }

    //构建头信息
    private void createHeadInfo(int code) {
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);

        switch (code) {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        //2、响应头（最后一行存在空行）
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:shsxtServer/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }
}

