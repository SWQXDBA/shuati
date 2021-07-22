package 力扣题目.二叉树.堆;

import java.util.PriorityQueue;

public class 最小k个数 {
    //最简单解法 排序然后复制个新的数组返回
//    public int[] smallestK(int[] arr, int k) {
//        Arrays.sort(arr);
//        return Arrays.copyOfRange(arr,0,k);
//    }


    public int[] smallestK(int[] arr, int k) {
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


}
