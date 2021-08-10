package MyTools.多线程.JUC使用.AQS;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁 {
    public static void main(String[] args) {
        DataContainer container = new DataContainer();
        Thread t1 = new Thread(() -> {
            container.read();
        });
        Thread t2 = new Thread(() -> {
            container.read();
        });
        Thread t3 = new Thread(() -> {
            container.write();
        });
        Thread t4 = new Thread(() -> {
            container.write();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static class DataContainer {
        Object data = new Object();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rl = lock.readLock();
        ReentrantReadWriteLock.WriteLock wl = lock.writeLock();

        public void read() {
            rl.lock();

            Debugger.debug("读操作中");

            Sleeper.sleep(1000);
            Debugger.debug("读完毕");
            rl.unlock();
        }

        public void write() {
            wl.lock();
            Debugger.debug("写操作中");
            Sleeper.sleep(1000);
            Debugger.debug("写完毕");
            wl.unlock();
        }


    }
}
