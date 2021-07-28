package 作业.暑假21年;

import java.util.*;

public class 两个数组的交集 {
    static public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums1);

        for (int i : nums2) {
            if (Arrays.binarySearch(nums1, i) >= 0 && !set.contains(i)) {
                set.add(i);
                ret.add(i);
            }
        }

        return Arrays.stream(ret.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }
}
