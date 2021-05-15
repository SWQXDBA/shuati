package 每日一题;

import java.util.Scanner;

public class 年终奖 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];
        while (scanner.hasNext()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println(getMax(arr, 0, 0));
        }
    }

    static int getMax(int[][] arr, int x, int y) {
        int num = arr[x][y];
        if (x == 5 && y == 5) {
            return num;
        }
        if (x == 5) {
            return num + getMax(arr, x, y + 1);
        }
        if (y == 5) {
            return num + getMax(arr, x + 1, y);
        }
        int right = getMax(arr, x, y + 1);
        int under = getMax(arr, x + 1, y);
        num += Math.max(right, under);
        return num;

    }

}
