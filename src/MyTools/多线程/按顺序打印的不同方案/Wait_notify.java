package MyTools.多线程.按顺序打印的不同方案;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Wait_notify {
    public static void main(String[] args) {

        final AtomicInteger integer = new AtomicInteger(0);
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < stringList.size(); i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                while (count.get() < 10) {
                    synchronized (Wait_notify.class) {
                        while (integer.get() != index) {
                            try {
                                Wait_notify.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(stringList.get(index));
                        if (integer.get() == stringList.size() - 1) {
                            integer.set(0);
                        } else {
                            integer.incrementAndGet();
                        }
                        count.incrementAndGet();
                        Wait_notify.class.notifyAll();
                    }
                }


            });
            thread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
