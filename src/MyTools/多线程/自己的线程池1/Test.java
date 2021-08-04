package MyTools.多线程.自己的线程池1;

import MyTools.我的数据结构.MySort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        for (int threadCount = 1; threadCount <= 8; threadCount++) {
            MyThreadPool pool = new MyThreadPool(threadCount);
            Random random = new Random();
            Integer[] base_arr;
            base_arr = new Integer[5000];
            for (int j = 0; j < base_arr.length; j++) {
                base_arr[j] = Math.abs(random.nextInt() % 100);
            }
            System.out.println("start");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                pool.add(new Mission() {
                    @Override
                    public void doMission() {
                        MySort.quickSort(Arrays.copyOf(base_arr, base_arr.length), Integer::compare);
                        //  System.out.println(Arrays.toString(arr));
                    }
                });
            }


            pool.join();
            long use = System.currentTimeMillis() - start;
            System.out.println("调用线程数:" + threadCount);
            System.out.println("总运行时间" + use + "mills");
            System.out.println("单核效率" + 10000.0 / (threadCount * use));
            System.out.println("总效率" + (10000.0 / use));
            System.out.println("___________________________");

        }

    }
}
