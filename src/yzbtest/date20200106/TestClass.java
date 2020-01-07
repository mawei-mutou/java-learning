package yzbtest.date20200106;

public class TestClass {

    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("");
            }
        };

        // 匿名
        TestInterFace testInterFace = new TestInterFace() {
            @Override
            public void hello() {
                System.out.println("hello!");
            }
        };
    }

    // 显式继承
    static class TmpChild implements TestInterFace{

        @Override
        public void hello() {

        }
    }
}
