package 测试;

import MyTools.工具类.Debugger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class 线程同步开销 {
    public static void main(String[] args) {
        new 线程同步开销().test2();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void test() {
        final ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicLong atomicLong = new AtomicLong();
/*
        service.execute(() -> {
            Debugger.info("start..");
            while (true) {
                if (atomicLong.getAndIncrement() >= 10000) {
                    Debugger.info("s1 end");
                    return;
                }

            }
        });
*/

        service.execute(() -> {
            Debugger.info("start..");
            while (true) {
                synchronized (this) {
                    notifyAll();
                    for (int i = 0; i < 1000; i++) {
                        if (atomicLong.getAndIncrement() >= 10000) {
                            Debugger.info("s1 end");
                            return;
                        }
                    }

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.execute(() -> {
            while (true) {
                synchronized (this) {
                    notifyAll();
                    for (int i = 0; i < 1000; i++) {
                        if (atomicLong.getAndIncrement() >= 10000) {
                            Debugger.info("s2 end");
                            return;
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    void test2() {

        for (int i = 0; i < 100000; i++) {
            synchronized (this) {

            }
            int k = 5;
            k += i;
        }
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 100000; i++) {
            lock.lock();
            lock.unlock();
        }
        Debugger.info("hot end");
        Debugger.info("start");
        ReentrantLock lock2 = new ReentrantLock();
        for (int i = 0; i < 100000; i++) {
            lock2.lock();
            for (int j = 0; j < 10000; j++) {
                int k = 0;
                k++;
                if (k == j) {
                    k--;
                }
            }
            lock2.unlock();
        }
        Debugger.info("end");

        Debugger.info("start2");
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                int k = 0;
                k++;
                if (k == j) {
                    k--;
                }
            }
        }
        Debugger.info("end2");
    }
}
