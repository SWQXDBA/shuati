package MyTools.多线程.自己的线程池1;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

public class CallerPoolTest {
    public static void main(String[] args) throws InterruptedException {
        MyCallableThreadPool<Integer> pool = new MyCallableThreadPool<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Integer[] arr = new Integer[10];
            for (int j = 0; j < 10; j++) {
                arr[j] = Math.abs(random.nextInt() % 100);
            }
            pool.addCaller("第" + i + "个数组", new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i1 : arr) {
                        sum += i1;
                    }
                    return sum;
                }
            });
            System.out.println(Arrays.toString(arr));
        }
        pool.join();
        for (int i = 0; i < 50; i++) {
            System.out.println(pool.joinAndGet("第" + i + "个数组"));
        }


    }
}
