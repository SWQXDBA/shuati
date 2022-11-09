package 测试;

import MyTools.工具类.StopWatch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class 加锁性能测试 {
    static int i = 0;

    public static void main(String[] args) {
        test5();
        test6();
        test7();
        test8();
        System.out.println("///");
        test5();
        test6();
        test7();
        test8();
    }

    static void test1() {
        int val = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                synchronized (加锁性能测试.class) {
                    val++;

                }

            }
        }

        System.out.println(stopWatch.getPassedMills());

    }

    static void test3() {
        int val = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                val++;

            }
            final Thread thread = Thread.currentThread();

        }

        System.out.println(stopWatch.getPassedMills());

    }

    static void test2() {

        AtomicInteger atomicInteger = new AtomicInteger();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100000; j++) {
                atomicInteger.getAndIncrement();
            }
        }

//        System.out.println(stopWatch.getPassedMills());

    }

    static void test5() {

        System.out.println("atomicInteger");
        AtomicInteger atomicInteger = new AtomicInteger();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {

                    atomicInteger.getAndIncrement();
                }

            });
            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger.get());
        System.out.println(stopWatch.getPassedMills());

    }

    static void test6() {

        System.out.println("synchronized");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    synchronized (加锁性能测试.class) {
                        加锁性能测试.i++;
                    }
                }
            });
            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);
        System.out.println(stopWatch.getPassedMills());

    }

    static void test7() {

        System.out.println("ReentrantLock");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread[] threads = new Thread[10];
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {

                for (int j = 0; j < 10000000; j++) {
                    lock.lock();
                    加锁性能测试.i++;
                    lock.unlock();
                }

            });

            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);
        System.out.println(stopWatch.getPassedMills());

    }

    static void test8() {
        LongAdder longAdder = new LongAdder();
        System.out.println("longAdder");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {

                for (int j = 0; j < 10000000; j++) {
                    longAdder.increment();
                }

            });

            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(longAdder.intValue());
        System.out.println(stopWatch.getPassedMills());

    }
}
