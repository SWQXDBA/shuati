import MyTools.工具类.Sleeper;
import MyTools.工具类.StopWatch;
import MyTools.我的数据结构.MyConcurrentCollection;
import MyTools.我的数据结构.多线程集合性能测试.ParallelCollectionTest;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author SWQXDBA
 */
public class Main {
    public static void test2() {

        MyConcurrentCollection<String> linkedBlockingQueue = new MyConcurrentCollection<>(3);
        StopWatch stopWatch = new StopWatch();
        final ExecutorService service = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                for (int j = 0; j < 100000; j++) {
                    linkedBlockingQueue.takeOne();
                }

            });
        }

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            service.execute(() -> {
                for (int j = 0; j < 100000; j++) {
                    linkedBlockingQueue.add("." + finalI);
                }

            });
        }
        service.shutdown();
        try {
            service.awaitTermination(100, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(linkedBlockingQueue.getClass()+" "+stopWatch.getPassedMills());

    }

    public static void test1() {

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        StopWatch stopWatch = new StopWatch();
        final ExecutorService service = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                try {
                    for (int j = 0; j < 100000; j++) {
                        linkedBlockingQueue.take();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            service.execute(() -> {
                for (int j = 0; j < 100000; j++) {
                    linkedBlockingQueue.add("." + finalI);
                }

            });
        }
        service.shutdown();
        try {
            service.awaitTermination(100, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(linkedBlockingQueue.getClass()+" "+stopWatch.getPassedMills());

    }

    public static void main(String[] args) {
        test1();



        test1();
        test2();

    }


}

