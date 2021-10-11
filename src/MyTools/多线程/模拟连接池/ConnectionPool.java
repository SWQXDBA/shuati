package MyTools.多线程.模拟连接池;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ConnectionPool {
    private final MockConnection[] connections;
    private final AtomicReferenceArray<Boolean> state;
    private final int capacity;
    volatile private int size = 0;

    public ConnectionPool(int capacity) {
        this.capacity = capacity;
        connections = new MockConnection[capacity];
        state = new AtomicReferenceArray<>(capacity);
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(3);
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

    private synchronized void addConnection() {
        if (size < capacity) {
            connections[size] = new MockConnection();
            state.set(size, Boolean.FALSE);
            size++;
        }

    }

    public Connection borrow() {

        while (true) {
            int size = this.size;
            for (int i = 0; i < size; i++) {
                if (!state.get(i)) {
                    //这里尝试获得连接 如果cas成功 说明他获得了连接的所有权
                    if (state.compareAndSet(i, false, true)) {
                        System.out.println("连接成功");
                        return connections[i];
                    }
                }
            }
            if (size < capacity) {
                addConnection();
            } else {
                synchronized (this) {
                    try {
                        //   System.out.println("等待新的可用连接");
                        wait();
                        //    System.out.println("有新的连接了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean free(Connection connection) {
        int size = this.size;
        for (int i = 0; i < size; i++) {
            if (connections[i] == connection) {
                state.set(i, false);
                synchronized (this) {
                    System.out.println("归还了连接！！！！！！！！！！！！！！！！！！");
                    notifyAll();
                }
                return true;
            }
        }
        return false;
    }
}
