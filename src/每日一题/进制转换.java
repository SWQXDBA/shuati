package 每日一题;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        System.out.println(change(M, N));
        // System.out.println(Integer.toString(M, N));
    }

    public static String change(int x, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        if (x < 0) {
            x *= -1;
            flag = true;
        }
        while (x != 0) {
            int cnt = x % n;
            if (cnt < 9) {
                stringBuilder.append(cnt);
            } else {
                stringBuilder.append((char) ('A' + cnt - 10));
            }
            x /= n;

        }
        if (flag) {
            stringBuilder.append("-");
        }
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

}
