package MyTools.工具类;

import java.util.function.Function;


public class TimeTest {
    public static void test(Runnable r){
        StopWatch watch = new StopWatch();
        r.run();
        System.out.println("耗时 "+ watch.getPassedMills()+" mills");
    }
}
