package MyTools.多线程.ReentrantLock可重入锁;

import java.util.concurrent.locks.ReentrantLock;

public class 可打断锁lockInterruptibly {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                //没有竞争 就可以获得锁 如果有竞争 则进入阻塞队列 可以被其他线程打断阻塞抛出异常InterruptedException
                reentrantLock.lockInterruptibly();

            } catch (InterruptedException e) {
                System.out.println("被打断了");
                e.printStackTrace();
                return;
            }
            try {
                System.out.println("获得到了锁");
            } finally {

                reentrantLock.unlock();
                System.out.println("解锁了");
            }

        });
        t1.start();
        Thread t2 = new Thread(t1);
        t2.start();

        t1.interrupt();
    }
}
