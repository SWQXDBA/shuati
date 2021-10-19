package 每日一题;

import java.util.Scanner;

public class 走方格的方案数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            int res = 1;
            int nxy = x + y;
            for (int i = 0; i < x; i++) {
                res *= nxy--;
            }
            for (int i = x; i >= 1; i--) {
                res /= i;
            }
            System.out.println(res);
        }
    }
}
