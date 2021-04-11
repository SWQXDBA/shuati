import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 丑数2 {
    public static void main(String[] args) {
        new Solution().nthUglyNumber(1407);
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            int[] nums = {2, 3, 5};
            PriorityQueue<Long> minHeap = new PriorityQueue();
            Set<Long> set = new HashSet<>();// 用来去重
            int cnt = 1;
            set.add(1L);
            minHeap.offer(1L);
            while (cnt < n) {
                Long ug = minHeap.poll();//取出一个丑数
                System.out.println(ug);
                cnt++;
                for (int i : nums) {//加入他的2、3、5倍数.
                    if (set.add(ug * i)) {//避免重复数字
                        minHeap.offer(ug * i);
                    }
                }
            }
            return minHeap.peek().intValue();
        }
    }
}
