import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SWQXDBA
 */
public class Main {

    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(2);
        long start = System.currentTimeMillis();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1";
        }, service);
        final CompletableFuture<String> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
                System.out.println(System.currentTimeMillis() - start);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        });
        final CompletableFuture<String> stringCompletableFuture = future.thenCombine(objectCompletableFuture, (f1, f2) -> {
            return f1 + f2;
        });

        try {
            System.out.println(stringCompletableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }


}

