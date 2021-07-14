package 作业.暑假21年;

import java.util.Arrays;

public class 找出两个只出现一次的数字 {
    static int[] func(int[] nums) {
        int basic = 0;
        for (int i : nums) {
            basic ^= i;
        }
        int index = 0;
        while ((basic & 1) != 1) {
            basic >>= 1;
            index++;
        }
        int[] ret = new int[2];
        for (int i : nums) {
            if (((i >> index & 1) == 0)) {
                ret[0] ^= i;
            } else {
                ret[1] ^= i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 1, 3, 5, 9};
        System.out.println(Arrays.toString(func(arr)));
    }
}
