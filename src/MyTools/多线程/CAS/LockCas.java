package MyTools.多线程.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自旋锁
 */
public class LockCas {
    AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) {
        LockCas lock = new LockCas();
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("线程1获得了锁");
            try {
                Thread.sleep(1000);
                System.out.println("线程1释放了锁");
                lock.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println("线程2获得了锁");
            try {
                Thread.sleep(1000);
                System.out.println("线程2释放了锁");
                lock.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        state.set(0);
    }
}
