public class Main {

    static void fun() {
        System.out.println("1");
    }

    public static void main(String[] args) {
        ((Main) null).fun();
    }

}
