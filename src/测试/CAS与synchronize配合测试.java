package 测试;

import MyTools.工具类.StopWatch;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CAS与synchronize配合测试 {
    static long cnt = 0;
    static int threadsCount = 36;
    static int executeCount = 500;
    static int casTryCount = 1;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test5();
    }

    public static void test1() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("直接加锁");
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < executeCount; j++) {
                    synchronized (CAS与synchronize配合测试.class) {
                        CAS与synchronize配合测试.cnt = CAS与synchronize配合测试.cnt + 1;
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(stopWatch.getPassedMills());
    }

    public static void test2() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("仅cas");
        List<Thread> threads = new ArrayList<>();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {

            final VarHandle handle = lookup.findStaticVarHandle(CAS与synchronize配合测试.class, "cnt", long.class);
            for (int i = 0; i < threadsCount; i++) {
                Thread thread = new Thread(() -> {
                    for (int j = 0; j < executeCount; j++) {
                        long cnt1 = CAS与synchronize配合测试.cnt;
                        while (!handle.compareAndSet(cnt1, cnt1 + 1)) {
                            cnt1 = CAS与synchronize配合测试.cnt;
                        }
                    }
                });
                threads.add(thread);
                thread.start();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(stopWatch.getPassedMills());
    }

    public static void test3() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("cas+锁");
        List<Thread> threads = new ArrayList<>();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {

            final VarHandle handle = lookup.findStaticVarHandle(CAS与synchronize配合测试.class, "cnt", long.class);
            for (int i = 0; i < threadsCount; i++) {
                Thread thread = new Thread(() -> {
                    for (int j = 0; j < executeCount; j++) {
                        long cnt1 = CAS与synchronize配合测试.cnt;
                        int tryCount = 0;

                        while (tryCount < casTryCount && !handle.compareAndSet(cnt1, cnt1 + 1)) {
                            tryCount++;
                            cnt1 = CAS与synchronize配合测试.cnt;
                        }
                        if (tryCount == casTryCount) {
                            synchronized (CAS与synchronize配合测试.class) {
                                while (!handle.compareAndSet(cnt1, cnt1 + 1)) {
                                    cnt1 = CAS与synchronize配合测试.cnt;
                                }
                            }
                        }
                    }
                });
                threads.add(thread);
                thread.start();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(stopWatch.getPassedMills());
    }

    public static void test5() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("阻塞队列");
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        for (int i = 0; i < threadsCount; i++) {

            for (int j = 0; j < executeCount; j++) {

                executorService.submit(() -> {
                    CAS与synchronize配合测试.cnt++;
                });


            }
        }


        try {
            executorService.shutdown();
            executorService.awaitTermination(9999, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stopWatch.getPassedMills());
    }
}
