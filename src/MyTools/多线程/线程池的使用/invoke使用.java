package MyTools.多线程.线程池的使用;

import MyTools.工具类.Sleeper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class invoke使用 {
    public static void main(String[] args) {
        //invoke会阻塞并等待所有任务执行完毕
        ExecutorService pool = Executors.newFixedThreadPool(10);
        try {
            List<Future<String>> list = pool.invokeAll(Arrays.asList(() -> {
                Sleeper.sleep(1000);
                return "ok";
            }, () -> {
                Sleeper.sleep(2000);
                return "ok";
            }, () -> {
                Sleeper.sleep(3000);
                return "ok";
            }));
            for (Future<String> future : list) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
