import MyTools.工具类.RandomTool;
import MyTools.工具类.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SWQXDBA
 */
class MyArrayBlockingQueue<T> {
    Object[] elements;

    volatile AtomicInteger size = new AtomicInteger(0);
    volatile int cap;
    volatile int head = 0;
    volatile int last = 0;
    ReentrantLock putLock = new ReentrantLock(false);
    ReentrantLock takeLock = new ReentrantLock(false);
    Condition notFull = putLock.newCondition();
    Condition notEmpty = takeLock.newCondition();

    public MyArrayBlockingQueue(int cap) {
        this.cap = cap;
        this.elements = new Object[cap];
    }


    private int next(int i) {
        int next = i + 1;
        if (next < this.cap) {
            return next;
        } else {
            return 0;
        }
    }

    private boolean isFull() {
        return cap == size.get();
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    public T take() throws InterruptedException {
        final Object element;
        takeLock.lock();
        try {
            while (isEmpty()) {
                notEmpty.await();
            }
            element = elements[head];
            elements[head] = null;
            head = next(head);
            if (size.decrementAndGet() == cap-1) {
                putLock.lock();
                try {
                    notFull.signal();
                } finally {
                    putLock.unlock();
                }
            }
            return (T) element;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw e;
        } finally {
            takeLock.unlock();
        }

    }

    public void put(T t) throws InterruptedException {
        putLock.lock();
        try {
            while (isFull()) {
                notFull.await();
            }
            elements[last] = t;
            last = next(last);

            if (this.size.incrementAndGet() == 1) {
                takeLock.lock();
                try {
                    notEmpty.signal();
                } finally {
                    takeLock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw e;
        } finally {
            putLock.unlock();
        }
    }
}
public class Main {
    static int v = 100000;
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 2; j++) {
            var integers = new LinkedBlockingQueue<Integer>(100000000);
            StopWatch stopWatch = new StopWatch();
            for (int i = 0; i < 100000000; i++) {
                integers.put(1);
                integers.take();
            }

            System.out.println();
            System.out.println(stopWatch.getPassedMills());
        }


    }

    public static void test1() {
        System.out.println("头插");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < v; i++) {
            list.add(0, i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < v; i++) {
            list2.add(0, i);
        }
        System.out.println(stopWatch.getPassedMills());
    }

    public static void test2() {
        System.out.println("尾插");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < v; i++) {
            list.add(i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < v; i++) {
            list2.add(i);
        }
        System.out.println(stopWatch.getPassedMills());
    }

    public static void test3() {
        System.out.println("中间插入");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }

        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < v; i++) {
            list.add(list2.size() / 2, i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < v; i++) {
            list2.add(list2.size() / 2, i);
        }
        System.out.println(stopWatch.getPassedMills());
    }

    public static void test4() {
        System.out.println("中间查找");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            list.add(i);
        }
        for (int i = 0; i < v; i++) {
            list2.add(i);
        }
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < 10000; i++) {
            list.get(v / 2 + i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < 10000; i++) {
            list2.get(v / 2 + i);
        }
        System.out.println(stopWatch.getPassedMills());
    }
}

