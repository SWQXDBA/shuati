package 每日一题;

import java.util.Scanner;

public class 计算糖果 {
    //牛客
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B, C, D;
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        D = scanner.nextInt();
        for (int i = -30; i <= 30; i++) {
            for (int j = -30; j <= 30; j++) {
                for (int k = -30; k <= 30; k++) {
                    if (i - j == A && j - k == B && i + j == C && j + k == D) {
                        System.out.print(i + " " + j + " " + k);
                        return;
                    }
                }
            }
        }
        System.out.println("No");

    }
}
