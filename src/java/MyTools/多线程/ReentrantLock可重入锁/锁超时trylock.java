package MyTools.多线程.ReentrantLock可重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class 锁超时trylock {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        //如果reentrantLock.tryLock() 不填时间参数 则获得不了锁后会立刻失败 不会继续等待
        Thread t1 = new Thread(() -> {
            try {
                if (reentrantLock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("上锁成功");
                    reentrantLock.unlock();
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上锁失败");

        });
        reentrantLock.lock();
        t1.start();
    }
}
