package MyTools.多线程.生产者消费者;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    final List<String> messages = new ArrayList<>();

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("消费者1消费了 " + queue.getMessage());

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("消费者2消费了 " + queue.getMessage());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                queue.put("生产者1号的产品" + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                queue.put("生产者2号的产品" + i);
            }
        }).start();
    }

    public String getMessage() throws InterruptedException {
        String ret = null;
        synchronized (messages) {
            while (messages.isEmpty()) {
                messages.wait();//注意！！要由被锁对象的对象调用
            }
            ret = messages.remove(0);
        }
        return ret;
    }

    public void put(String message) {
        synchronized (messages) {
            messages.add(message);
            messages.notifyAll();//注意！！要由被锁对象的对象调用

        }

    }
}
