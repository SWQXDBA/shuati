package 软件与程序设计兴趣小组比赛.十月二日;

import java.util.Scanner;

public class 铺水泥 {//超时了

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] array = new int[n][n];
            for (int i = 0; i < m; i++) {
                int x1, y1, x2, y2;
                x1 = scanner.nextInt() - 1;
                y1 = scanner.nextInt() - 1;
                x2 = scanner.nextInt() - 1;
                y2 = scanner.nextInt() - 1;
                for (int j = x1; j <= x2; j++) {
                    for (int k = y1; k <= y2; k++) {
                        array[j][k]++;
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j]);
                    if (j != array[0].length - 1) {
                        System.out.print(" ");
                    }
                }
                if (i != array.length - 1) {
                    System.out.println();
                }
            }
        }
    }
}
