public class Main {


    static int a;

    static {
        a = 5;
        System.out.println(a);
    }

    public Main() {

    }

    public static void tt() {
        System.out.println(a);
    }

    public static int Main(int a) {
        return a;
    }

    public static void main(String[] args) {
        Main m = null;
        m.tt();
        System.out.println(Main.Main(6));
    }
}