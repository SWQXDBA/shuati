package 每日一题;

import java.util.Scanner;

public class Fibonacci数列最小步数 {
    public static void main(String[] args) {
        int[] fibs = new int[1000000];
        fibs[1] = 1;
        for (int i = 2; i < fibs.length; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int left = 0;
            int right = 0;
            for (int i = 0; i < fibs.length; i++) {
                if (fibs[i] > x) {
                    left = i - 1;
                    right = i;
                    break;
                }
            }
            System.out.println(Math.min(x - fibs[left], fibs[right] - x));
        }

    }
}
