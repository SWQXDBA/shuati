package 每日一题;

import java.util.Scanner;

public class 完全数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int cnt = 0;
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                if (inNum(i))
                    cnt++;
            }
            System.out.println(cnt);
        }
    }

    static boolean inNum(int n) {

        int sum = 0;
        double sqrt = Math.sqrt(n);
        for (int i = 1; i < sqrt; i++) {
            if (n % i == 0) {
                sum += i;
                sum += (n / i);
            }
        }
        return n == sum - n;
    }
}
