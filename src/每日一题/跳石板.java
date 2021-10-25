package 每日一题;

import java.util.Scanner;

public class 跳石板 {
    //参考： https://blog.csdn.net/qq_24210431/article/details/104436970
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[] dp = new int[m + 1];

            for (int i = n; i <= m; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[n] = 0;
            for (int i = n; i <= m; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue;//不可达
                }
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        if (i + j <= m) {//一个因数
                            dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                        }
                        if (i + (i / j) <= m) {//另一个因数
                            int cnt = i / j;
                            dp[i + cnt] = Math.min(dp[i + cnt], dp[i] + 1);
                        }
                    }

                }
            }

            if (dp[m] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dp[m]);
            }

        }
    }
}
