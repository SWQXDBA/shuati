package 每日一题;

import java.util.Scanner;

public class 小易的升级之路 {
    public static int gongbeishu(int a, int b) {
        while (a % b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n, a;
            n = scanner.nextInt();
            a = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int c = scanner.nextInt();
                if (a >= c) {
                    a += c;
                } else {
                    a += gongbeishu(a, c);
                }
            }
            System.out.println(a);
        }
    }
}
