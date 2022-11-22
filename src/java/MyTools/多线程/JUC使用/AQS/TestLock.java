package MyTools.多线程.JUC使用.AQS;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

public class TestLock {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                Debugger.debug("上锁了");
                Sleeper.sleep(2000);
                Debugger.debug("解锁了");
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                Debugger.debug("上锁了");
                Sleeper.sleep(2000);
                Debugger.debug("解锁了");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                lock.lock();
                Debugger.debug("上锁了");
                lock.lock();
                Debugger.debug("重入了");
                Sleeper.sleep(2000);
                Debugger.debug("解锁了");
            } finally {
                lock.unlock();
            }
        });
        t3.start();
    }


}
