package 作业.暑假21年;

import java.util.*;

public class 两个数组的交集2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                int n = map.get(i);
                if (n > 0) {
                    map.put(i, n - 1);
                    list.add(i);
                }
            }
        }
        return Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }
}
