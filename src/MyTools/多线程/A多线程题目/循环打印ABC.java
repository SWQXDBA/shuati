package MyTools.多线程.A多线程题目;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class 循环打印ABC {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        Thread threadA = new Thread(() -> {
            try {
                for (int j = 0; j < 10; j++) {
                    semaphoreA.acquire();
                    System.out.print("A ");
                    semaphoreB.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                for (int j = 0; j < 10; j++) {
                    semaphoreB.acquire();
                    System.out.print("B ");
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                for (int j = 0; j < 10; j++) {
                    semaphoreC.acquire();
                    System.out.println("C");
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();

    }
}
