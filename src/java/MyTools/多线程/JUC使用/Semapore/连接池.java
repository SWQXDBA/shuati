package MyTools.多线程.JUC使用.Semapore;

import MyTools.多线程.模拟连接池.MockConnection;

import java.sql.Connection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class 连接池 {

    static class ConnectionPoolSemapore {
        private final MockConnection[] connections;
        private final AtomicReferenceArray<Boolean> state;
        Semaphore semaphore;
        volatile private int size = 0;

        //由于没有static的成员 因此认为构造器是线程安全的
        public ConnectionPoolSemapore(int capacity) {
            connections = new MockConnection[capacity];
            state = new AtomicReferenceArray<>(capacity);
            semaphore = new Semaphore(capacity);
            while (size < capacity) {
                connections[size] = new MockConnection();
                state.set(size, false);
                size++;
            }
        }

        public static void main(String[] args) {
            ConnectionPoolSemapore pool = new ConnectionPoolSemapore(3);
            for (int i = 0; i < 1000; i++) {
                int finalI = i;
                new Thread(() -> {
                    System.out.println(finalI + "想获取连接");
                    Connection c = pool.borrow();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        pool.free(c);
                    }
                }).start();
            }

        }

        public Connection borrow() {

            try {
                semaphore.acquire();
                for (int i = 0; i < size; i++) {
                    if (!state.get(i)) {
                        if (state.compareAndSet(i, false, true)) {
                            System.out.println("连接成功");
                            return connections[i];
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        public boolean free(Connection connection) {

            for (int i = 0; i < size; i++) {
                if (connections[i] == connection) {
                    state.set(i, false);
                    semaphore.release();
                    System.out.println("归还了连接！！！！！！！！！！！！！！！！！！");
                    return true;
                }
            }
            return false;
        }
    }
}
