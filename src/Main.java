public class Main {


    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();

        for (int i = 0; i < 10; i++) {
            int t = i;
            Thread thread = new Thread(() -> {
                local.set("你好" + t);
                System.out.println(local.get());
            });
            thread.start();
        }


    }


}

