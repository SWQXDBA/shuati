package 每日一题;

import java.util.Scanner;


public class 排序子序列 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int cnt = 1;
            int step = 0;
            int state = 0;
            while (step + 1 < nums.length) {
                if (nums[step + 1] < nums[step]) {
                    if (state == 0) {
                        state = 1;
                    } else if (state == 2) {
                        state = 0;
                        cnt++;
                    }
                } else if (nums[step + 1] > nums[step]) {
                    if (state == 0) {
                        state = 2;
                    } else if (state == 1) {
                        state = 0;
                        cnt++;
                    }
                }
                step++;
            }
            System.out.println(cnt);


        }


    }

}
