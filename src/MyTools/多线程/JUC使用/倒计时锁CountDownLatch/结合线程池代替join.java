package MyTools.多线程.JUC使用.倒计时锁CountDownLatch;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 结合线程池代替join {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(6);
        CountDownLatch latch = new CountDownLatch(10);
        service.execute(() -> {
            try {
                Debugger.debug("开始等待");
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Debugger.debug("结束等待");

        });
        for (int i = 0; i < 10; i++) {
            Sleeper.sleep(10);
            service.execute(latch::countDown);
        }
    }
}
