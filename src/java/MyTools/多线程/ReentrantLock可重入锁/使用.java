package MyTools.多线程.ReentrantLock可重入锁;

import java.util.concurrent.locks.ReentrantLock;

public class 使用 {
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new 使用().func();
    }

    public void func() {
        try {
            reentrantLock.lock();
            System.out.println("f1调用了");
            func2();

        } finally {
            reentrantLock.unlock();
        }
    }

    public void func2() {
        try {
            reentrantLock.lock();
            System.out.println("f2调用了");
            func3();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void func3() {
        try {
            reentrantLock.lock();
            System.out.println("f3调用了");

        } finally {
            reentrantLock.unlock();
        }
    }
}
