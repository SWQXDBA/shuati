import MyTools.工具类.Sleeper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int cnt = 20;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(cnt);
        Thread product = new Thread(() -> {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("生产了1 剩余" + queue.remainingCapacity());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Sleeper.sleep(200);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    queue.take();
                    System.out.println("消费了1 剩余" + queue.remainingCapacity());
                    Sleeper.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        product.start();
        consumer.start();


    }


}

