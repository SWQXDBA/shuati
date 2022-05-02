package 学校作业.java作业.多线程;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MQ {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        final ExecutorService producer = Executors.newFixedThreadPool(2, new ThreadFactory() {
            int id = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "生产者" + (id++));
            }
        });
        final ExecutorService consumer = Executors.newFixedThreadPool(2, new ThreadFactory() {
            int id = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "消费者" + (id++));
            }
        });
        AtomicInteger id = new AtomicInteger();
        for (int j = 0; j < 2; j++) {
            producer.execute(() -> {
                for (int i = 0; i < 15; i++) {
                    String message = "消息" + id.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + "生产了" + message);
                    try {
                        blockingQueue.put(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for (int j = 0; j < 2; j++) {
            consumer.execute(() -> {
                while (true) {
                    final String message;
                    try {
                        message = blockingQueue.take();
                        System.out.println(Thread.currentThread().getName() + "消费了" + message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }


    }
}
