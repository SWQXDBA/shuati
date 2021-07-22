package 作业.暑假21年;

import java.util.PriorityQueue;

public class 最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {


        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : stones) {
            heap.offer(i);
        }
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            int c = a - b;
            if (c != 0)
                heap.offer(c);
        }
        if (heap.isEmpty())
            return 0;
        return heap.poll();
    }


}
