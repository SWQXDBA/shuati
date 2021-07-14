package 作业.暑假21年;

public class 子数组和的最大值 {
    static int maxValue = Integer.MIN_VALUE;

    static public int maxSubArray(int[] nums) {
        maxValue = Integer.MIN_VALUE;
        fun(nums, nums.length - 1);
        return maxValue;
    }

    static int fun(int[] arr, int num) {
        if (num == 0) {
            maxValue = Math.max(arr[0], maxValue);
            return arr[0];
        }
        int minFun = fun(arr, num - 1);
        if (minFun < 0) {
            maxValue = Math.max(arr[num], maxValue);
            return arr[num];
        } else {
            maxValue = Math.max(minFun + arr[num], maxValue);
            return minFun + arr[num];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(maxSubArray(arr));
    }


}
