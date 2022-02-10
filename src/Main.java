import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main);
        main.test();

        try {
            CompletableFuture.runAsync(null).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        System.out.println(Main.this);
    }
}

