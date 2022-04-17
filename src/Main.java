import java.util.concurrent.*;

/**
 * @author SWQXDBA
 */
public class Main {

    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactory() {
            int num = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "" + (num++));
            }
        };
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 15, 100, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1), threadFactory);
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        final Runnable submit = (Runnable) executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        //  System.out.println("111");
        System.out.println(submit);
    }


}

