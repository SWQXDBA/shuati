package 作业.暑假21年;

import java.util.HashMap;
import java.util.Map;

public class 连续数组 {
    //前缀和+hashmap 由于求的是最大的长度 因此只要记录该前缀和第一次出现的位置。这样使得相减的结果最大
    public int findMaxLength(int[] nums) {
        int preSum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 1 ? 1 : -1;//0表示-1 1表示1
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            } else {
                max = Math.max(max, i - map.get(preSum));
            }
        }
        return max;
    }
}
