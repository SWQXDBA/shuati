public class Main {
private String cnt = "111";
    public static void main(String[] args) {
        test t1 = new test(1);
        test t2 = new test(1);

        System.out.println(t1.equals(t2));
    }

    static class test {
        int n;

        public test(int a) {
            n = a;
        }
    }
}

