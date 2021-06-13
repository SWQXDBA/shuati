package 力扣题目.剑指offer;

import java.util.PriorityQueue;

public class 剑指41 {
    static class MedianFinder {
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((x, y) -> (y - x));
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        int size = 0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if ((size % 2) == 0) {
                smallHeap.offer(num);
                int n = smallHeap.poll();
                bigHeap.offer(n);
            } else {
                bigHeap.offer(num);
                int n = bigHeap.poll();
                smallHeap.offer(n);
            }
            size++;
        }

        public double findMedian() {
            if (size % 2 == 0) {
                return (bigHeap.peek() + smallHeap.peek()) / 2.0;
            } else {
                return bigHeap.peek();
            }
        }
    }


}
