package 测试;

import MyTools.工具类.Sleeper;
import MyTools.工具类.StopWatch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class 阻塞队列开销测试 {
    public static void test1() {
        BlockingQueue<Runnable> missions = new LinkedBlockingQueue<>();
        Thread thread = new Thread(() -> {
            Sleeper.sleep(200);
            StopWatch stopWatch = new StopWatch();
            for (int i = 0; i < 1000; i++) {
                try {
                    missions.put(new Mission());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                missions.put(() -> System.out.println("BlockingQueue end " + stopWatch.getPassedMills()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        for (int i = 0; i < 1001; i++) {
            Runnable take = null;
            try {
                take = missions.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            take.run();
        }
    }

    public static void test2() {
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < 1000; i++) {
            new Mission().run();
        }
        System.out.println("Main end " + stopWatch.getPassedMills());
    }

    public static void main(String[] args) {

        test1();
        test1();
        test2();
        test2();
    }

    static class Mission implements Runnable {

        private void fun(int s) {

        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    sum += i;
                    if (sum == j) {
                        sum = 0;
                    }
                }
            }
            fun(sum);
        }
    }
}
