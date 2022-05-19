package MyTools.我的数据结构.多线程集合性能测试;

import MyTools.工具类.StopWatch;
import MyTools.我的数据结构.MyConcurrentCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelCollectionTest {
    public static void doTest(Collection<String> collection,int threadCount,int insertTimePerThread)  {
        final ExecutorService service = Executors.newFixedThreadPool(16);
        AtomicLong cnt = new AtomicLong((long) threadCount * insertTimePerThread);
        StopWatch stopWatch = new StopWatch();
        for (int j = 0; j < threadCount; j++) {
            int finalJ = j;
            service.execute(() -> {
                for (int i = 0; i < insertTimePerThread; i++) {
                    collection.add(finalJ + "a" + i);
                    cnt.getAndDecrement();
                }
                if (cnt.get() == 0) {
                    System.out.println(collection.getClass()+" use "+stopWatch.getPassedMills() + "mills " + collection.size());
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(999,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void testAll(int threadCount,int insertTimePerThread){

        //预热
        doTest(new Vector<>(),threadCount,insertTimePerThread);




       // Vector<String> collection = new Vector<>();
        MyConcurrentCollection<String> collection = new MyConcurrentCollection<>(16);
        final ExecutorService service = Executors.newFixedThreadPool(16);
        AtomicLong cnt = new AtomicLong((long) threadCount * insertTimePerThread);
        StopWatch stopWatch = new StopWatch();
        for (int j = 0; j < threadCount; j++) {
            int finalJ = j;
            service.execute(() -> {
                for (int i = 0; i < insertTimePerThread; i++) {
                    collection.add(finalJ + "a" + i);
                    cnt.getAndDecrement();
                }
                if (cnt.get() == 0) {
                    System.out.println(collection.getClass()+" use "+stopWatch.getPassedMills() + "mills " + collection.size());
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(999,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println();

        doTest(new Vector<>(),threadCount,insertTimePerThread);

        doTest(ConcurrentHashMap.newKeySet(),threadCount,insertTimePerThread);

        doTest(new LinkedBlockingQueue<>(),threadCount,insertTimePerThread);
        doTest(new LinkedBlockingDeque<>(),threadCount,insertTimePerThread);

        doTest(new ConcurrentLinkedQueue<>(),threadCount,insertTimePerThread);
        doTest(new ConcurrentLinkedDeque<>(),threadCount,insertTimePerThread);
        doTest(new ConcurrentSkipListSet<>(),threadCount,insertTimePerThread);

    }
}
