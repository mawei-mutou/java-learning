package yzbtest.date20200108;

public class TestEnum{
    public static void main(String[] args) {
//        Money dolar = new Money();
        System.out.println(Money.yuan);
    }
}

// Money 是一个枚举类
enum Money {
    // yuan,jiao,fen 这三个是 枚举类下唯三的 三个对象， 不能由其他地方再创建Money的对象了
    yuan,jiao,fen;

    // 私有构造方法
    Money() {
    }
}

