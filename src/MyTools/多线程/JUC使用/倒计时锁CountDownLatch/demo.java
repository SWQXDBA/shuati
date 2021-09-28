package MyTools.多线程.JUC使用.倒计时锁CountDownLatch;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.CountDownLatch;

public class demo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> {
                Sleeper.sleep(1000);
                Debugger.debug("减少了1");
                latch.countDown();

                try {
                    latch.await();
                    Debugger.debug("等待完成");
                    Debugger.debug(latch.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
        }

    }
}
