package MyTools.多线程.线程池的使用;

import MyTools.工具类.Debugger;

import java.util.concurrent.*;

public class demo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                Debugger.info("不带返回值");
            }
        });
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                Thread.sleep(3000);
                Debugger.debug("ok");
                return "返回值";
            }
        });
        try {
            Debugger.info(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
