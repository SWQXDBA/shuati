package 作业.大二上;

import java.util.concurrent.CountDownLatch;

public class 多线程打印 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(20);
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int t = i;
            threads[i] = new Thread(() -> {
                System.out.print(t + " ");
                latch.countDown();
            });
        }
        threads[0].start();
        for (int i = 1; i < 20; i++) {
            try {
                threads[i - 1].join();
                threads[i].start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            latch.await();
            System.out.print(" ok!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
