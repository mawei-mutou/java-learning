package date20200206;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/6
 * time        : 15:02
 * description :
 */
public class RDownLoader implements Runnable{
    private String url;
    private String name;

    public RDownLoader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader df = new WebDownloader();
        df.download(url, name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        RDownLoader td1 = new RDownLoader(
                "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=githup&step_word=&hs=0&pn=7&spn=0&di=4290&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=506167408%2C2657864158&os=3448747020%2C2288125626&simid=3366753286%2C110745511&adpicid=0&lpn=0&ln=1656&fr=&fmq=1580972842944_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimgs.logonews.cn%2Fuploads%2F2013%2F04%2Fgithub-new-logos_05.png&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bs525gjof_z%26e3BvgAzdH3F2tpi7k-gjo-s525_z%26e3Bip4s&gsm=&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "cate.jpg");
        RDownLoader td2 = new RDownLoader("https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E5%AE%88%E7%A0%B4%E7%A6%BB&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=&latest=&copyright=&cs=3081106514,3909537001&os=2770653049,292153157&simid=3485895847,391844794&pn=7&rn=1&di=23980&ln=224&fr=&fmq=1580973043155_R&fm=result&ic=&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fpic.xiami.net%2Fimages%2Falbum%2Fimg47%2F858447%2F8584471547858447.jpg%3Fx-oss-process%3Dimage%2Fresize%2Climit_0%2Cs_410%2Cm_fill&rpstart=0&rpnum=0&adpicid=0&force=undefined&ctd=1580973055457^3_1350X665%1", "spl.jpg");
        RDownLoader td3 = new RDownLoader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E6%9D%8E%E5%B0%8F%E9%BE%99&step_word=&hs=0&pn=3&spn=0&di=78540&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=2863560172%2C3427190906&os=1978379931%2C4153526849&simid=4263622168%2C718230529&adpicid=0&lpn=0&ln=3368&fr=&fmq=1580973019547_R&fm=result&ic=&s=undefined&hd=&latest=&copyright=&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=star&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170313%2F3e14bc7fc7914ed2ab34756fcd9adc7c_th.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3F4p_z%26e3Bf5i7_z%26e3Bv54AzdH3Fda80an8nAzdH3Fg9bndd0cmb_z%26e3Bfip4s&gsm=&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "lxc.jpg");

        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();

    }

}
