package date20200114;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/14
 * time        : 17:38
 * description :
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();
        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say {
    void say();
}

class Person implements Say {
    //属性
    private int voice = 10;

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    @Override
    public void say() {
        System.out.println("我的钱为："+this.getVoice());

    }
}

class Amplifier implements Say {
    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("我的钱为："+p.getVoice()*100);
        System.out.println("有钱！！！");
    }
}