package 每日一题;

import java.util.Scanner;

public class 连续最大和 {
    static long max = 0;
    static long sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            max = 0;
            sum = 0;
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int j : arr) {
                sum += j;
                if (sum < 0) {
                    sum = 0;
                }
                if (sum > max) {
                    max = sum;
                }
            }
            //接下来判断全部都是负数的情况 则找到最大的那个数
            boolean flag = false;
            for (int i : arr) {
                if (i >= 0) {
                    flag = true;
                }
            }
            if (!flag) {
                max = arr[0];
                for (int i : arr) {
                    if (i > max) {
                        max = i;
                    }
                }
            }
            System.out.println(max);
        }
    }

}
