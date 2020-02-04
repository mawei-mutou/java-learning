package date20200204;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/4
 * time        : 10:39
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

interface Say{
    void say();
}

class Person implements Say {
    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为：" + this.getVoice());

    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say {
    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为：" + p.getVoice() * 10);
        System.out.println("噪音！！！");
    }
}



