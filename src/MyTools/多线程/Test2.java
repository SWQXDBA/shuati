package MyTools.多线程;

import MyTools.我的数据结构.MySort;

import java.util.Arrays;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);

        Random random = new Random();
        Integer[] base_arr;
        base_arr = new Integer[10000];
        for (int j = 0; j < base_arr.length; j++) {
            base_arr[j] = Math.abs(random.nextInt() % 100);
        }
        System.out.println("start");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            pool.add(new Mission() {
                @Override
                public void doMission() {
                    MySort.insertSort(Arrays.copyOf(base_arr, base_arr.length), Integer::compare);
                    System.out.println("over");
                    //  System.out.println(Arrays.toString(arr));
                }
            });
        }
        System.out.println("ok");
        pool = null;
        System.gc();


    }
}
