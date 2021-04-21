public class Main {
    private static Integer aa = 10;

    public Main(int a) {
        aa = a;
    }

    public Main() {
        this(15);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.aa++;
        System.out.println(aa);
    }

}

class TestDemo {

    private int count;

    TestDemo(int a) {

        count = a;

    }

    public static void main(String[] args) {

        TestDemo test = new TestDemo(88);

        System.out.println(test.count);

    }

}

class Test {
    public static void main(String[] args) {
        System.out.println(new Test());
    }

    public String toString() {

        System.out.print("aaa");

        return "bbb";

    }

}