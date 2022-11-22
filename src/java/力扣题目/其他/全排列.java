package 力扣题目.其他;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        final List<List<Integer>> permute = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            compute(ans, new LinkedList<>(), 0, nums, new boolean[nums.length]);
            return ans;
        }

        public void compute(List<List<Integer>> ans, List<Integer> currentNums, int currentIndex, int[] nums, boolean[] used) {
            if (currentIndex == nums.length) {
                ans.add(new LinkedList<>(currentNums));
                return;
            }

            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {

                    used[i] = true;
                    int currentNum = nums[i];
                    currentNums.add(currentNum);

                    compute(ans, currentNums, currentIndex + 1, nums, used);

                    currentNums.remove(currentNums.size() - 1);
                    used[i] = false;
                }
            }

        }

    }
}
