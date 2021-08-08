package MyTools.多线程.ReentrantLock可重入锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 条件变量唤醒 {
    static boolean isRepaired1 = false;
    static boolean isRepaired2 = false;
    static ReentrantLock lock = new ReentrantLock();
    static Condition con1 = lock.newCondition();
    static Condition con2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        //注意 condition.await()与condition.signal()配套而不是notify()
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                while (!isRepaired1) {
                    con1.await();
                }
                System.out.println("条件1" + isRepaired1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                while (!isRepaired2) {
                    con2.await();
                }
                System.out.println("条件2" + isRepaired2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                lock.lock();
                if (!isRepaired1) {
                    isRepaired1 = true;
                    con1.signalAll();
                    System.out.println("条件1被唤醒了" + isRepaired1);
                }
            } finally {
                lock.unlock();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                lock.lock();
                if (!isRepaired2) {
                    isRepaired2 = true;
                    con2.signalAll();
                    System.out.println("条件2被唤醒了" + isRepaired2);
                }
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t4.start();
        Thread.sleep(1000);
        t3.start();
    }
}
