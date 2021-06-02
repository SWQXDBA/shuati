package 力扣题目.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 剑指57 {
    static public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        int start = 1;
        int end = target / 2;
        while (start <= end) {
            for (int i = start + 1; ; i++) {
                if (getNumSum(start, i) == target) {
                    int[] nums = new int[i - start + 1];
                    for (int j = 0; j <= i - start; j++) {
                        nums[j] = start + j;
                    }
                    list.add(nums);
                    break;
                }
                if (getNumSum(start, i) > target)
                    break;
            }
            start++;
        }
        int[][] ret = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    static int getNumSum(int from, int to) {
        return (from + to) * (to - from + 1) / 2;
    }

    public static void main(String[] args) {
        int[][] r = findContinuousSequence(9);
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                System.out.println(r[i][j]);
            }
        }
    }
}
