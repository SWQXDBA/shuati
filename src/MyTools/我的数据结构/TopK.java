package MyTools.我的数据结构;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class TopK {
    //  最简单解法 排序然后复制个新的数组返回
    static public int[] smallestK1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }


    static public int[] smallestHeap(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        //最小的k个数需要建大堆辅助完成
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (heap.size() < k) {
                heap.offer(i);
            } else {
                int top = heap.peek();
                if (top > i) {
                    heap.offer(i);
                    heap.poll();
                }
            }
        }
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = heap.poll();
        }
        return ret;
    }

    public static void main(String[] args) {

        Random random = new Random();
        int cnt = 1000000;
        int k = 10;
        int[] testArr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            testArr[i] = random.nextInt();
        }
        int[] testArr2 = Arrays.copyOf(testArr, testArr.length);
        long start = System.currentTimeMillis();
        smallestK1(testArr, k);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        smallestHeap(testArr, k);
        System.out.println(System.currentTimeMillis() - start);
        //结果可以得出 k的值越小 堆算法越快 排序耗时约为nlogn 而堆算法耗时nlogk


    }
}
