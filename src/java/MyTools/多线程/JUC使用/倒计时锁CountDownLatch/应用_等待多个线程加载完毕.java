package MyTools.多线程.JUC使用.倒计时锁CountDownLatch;

import MyTools.工具类.RandomTool;
import MyTools.工具类.Sleeper;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 应用_等待多个线程加载完毕 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(12);
        int[] threads = new int[10];
        for (int i = 0; i < 10; i++) {
            int t = i;
            service.execute(() -> {

                for (int j = 0; j <= 100; j += RandomTool.getRandomABS(5) % (101 - j)) {

                    Sleeper.sleepRandom(100);
                    threads[t] = j;
                    System.out.print(("\r" + Arrays.toString(threads)));
                    if (j == 100)
                        break;
                }
                latch.countDown();

            });

        }


        try {
            latch.await();
            System.out.println("加载完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
