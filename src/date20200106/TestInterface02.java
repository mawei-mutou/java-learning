package date20200106;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/6
 * time        : 16:49
 * description :
 */
public class TestInterface02 {

}
interface A {
    void testa();
}

interface B {
    void testb();
}

//接口可以多继承：接口c继承接口a和b

interface C extends A, B {
    void testc();
}

class Test implements C {

    @Override
    public void testa() {

    }

    @Override
    public void testb() {

    }

    @Override
    public void testc() {

    }
}