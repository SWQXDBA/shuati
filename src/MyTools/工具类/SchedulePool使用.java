package MyTools.工具类;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulePool使用 {
    static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);

    public static void main(String[] args) {
        //定时延时执行
        //test1();

        //间隔固定的时间开始
        //  test2();

        //两个任务之间间隔固定时间执行
        test3();

    }

    static void test1() {
        pool.schedule(() -> {
            Debugger.debug("第一个任务开始");
            Sleeper.sleep(2000);
            Debugger.debug("第一个任务完毕");
        }, 1, TimeUnit.SECONDS);
        pool.schedule(() -> {
            Debugger.debug("第二个任务开始");
            Sleeper.sleep(2000);
            Debugger.debug("第二个任务完毕");
        }, 1, TimeUnit.SECONDS);
    }

    static void test2() {
        //在initialDelay后被首次启用，之后每period执行一次
        //注意 period并不是从上个任务结束后开始算 而是从上个任务开始时计算。如果上个任务执行时间超过了等待时间，则下一次任务会立刻开始
        //如果此任务的任何执行时间超过其周期，则后续执行可能会延迟开始，但不会同时执行
        pool.scheduleAtFixedRate(() -> {
            Debugger.debug("第一个任务开始");
            Sleeper.sleep(2000);
            Debugger.debug("第一个任务完毕");
        }, 1, 3, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(() -> {
            Debugger.debug("第二个任务开始");
            Sleeper.sleep(2000);
            Debugger.debug("第二个任务完毕");
        }, 1, 2, TimeUnit.SECONDS);
    }

    static void test3() {
        //在initialDelay后被首次启用，之后每period执行一次
        //注意 period是从上一个任务结束后开始计算 就是每两个任务之间间隔一个period 不关心每个任务执行了多久
        pool.scheduleWithFixedDelay(() -> {
            Debugger.debug("第一个任务开始");
            Sleeper.sleep(2000);
            Debugger.debug("第一个任务完毕");
        }, 1, 3, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(() -> {
            Debugger.debug("第二个任务开始");
            Sleeper.sleep(2000);
            Debugger.debug("第二个任务完毕");
        }, 1, 2, TimeUnit.SECONDS);
    }
}
