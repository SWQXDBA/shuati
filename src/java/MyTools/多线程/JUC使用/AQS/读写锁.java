package MyTools.多线程.JUC使用.AQS;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁 {
    //备注 ReentrantReadWriteLock只能锁降级 把写锁降级为读锁
    //具体操作为 1先获得读锁 2再释放写锁 这样可以保证数据在此过程中不会被其他的线程锁修改
    //如果 先1释放写锁 2获得读锁 则12之间可能有其他的线程获得了写锁进行数据的修改 无法感知数据正确性

    //不支持锁升级 不能在拥有读锁的时候申请写锁必须先释放读锁再申请写锁 否则会导致死锁
    public static void main(String[] args) {
        DataContainer container = new DataContainer();
        container.writeToReadLock();
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

        public void readToWriteLock() {//不能锁升级 会导致死锁
            rl.lock();
            System.out.println("ok");
            wl.lock();//阻塞
            System.out.println("ok");
        }

        public void writeToReadLock() {//可以锁降级
            wl.lock();
            System.out.println("ok");
            rl.lock();
            System.out.println("ok");

            wl.unlock();
            rl.unlock();

        }

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
