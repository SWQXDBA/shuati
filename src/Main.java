public class Main {

    static class HelloA {
        static {
            System.out.println("static A");
        }

        {
            System.out.println("i am A class");
        }

        public HelloA() {
            System.out.println("HelloA");
        }
    }

    public static class TestClass extends HelloA {
        static {
            System.out.println("static TestClass");
        }

        {
            System.out.println("i am TestClass");
        }

        public TestClass() {
            System.out.println("TestClass");
        }

        public static void main(String[] args) {
            new TestClass();
            new TestClass();
        }
    }
}

