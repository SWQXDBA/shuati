package MyTools.多线程.按顺序打印的不同方案;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 条件唤醒 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();


        List<String> stringList = new ArrayList<>();
        List<Condition> conditions = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            stringList.add(i + "");
            conditions.add(reentrantLock.newCondition());
        }

        Semaphore semaphore = new Semaphore(stringList.size());
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < stringList.size(); i++) {
            final int index = i;
            final Condition condition = conditions.get(i);
            Thread thread = new Thread(() -> {
                while (count.get() < 10) {

                    try {
                        reentrantLock.lock();
                        semaphore.release();
                        condition.await();
                        count.incrementAndGet();
                        System.out.println(stringList.get(index));
                        Condition next = conditions.get(index == stringList.size() - 1 ? 0 : index + 1);
                        next.signal();

                    } catch (InterruptedException e) {

                        reentrantLock.unlock();

                        e.printStackTrace();
                    }

                }
            });
            thread.start();
        }

        try {

            semaphore.acquire(3);
            reentrantLock.lock();
            conditions.get(0).signal();
            reentrantLock.unlock();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
