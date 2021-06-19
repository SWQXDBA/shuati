package 力扣题目.剑指offer;

import java.util.Scanner;

public class 剑指13 {
    static boolean[][] worked = new boolean[100][100];
    static int num = 0;
    static int M, N;

    static public int movingCount(int m, int n, int k) {
        num = 0;
        worked = new boolean[100][100];
        M = m;
        N = n;
        work(0, 0, k);
        return num;
    }

    static void work(int m, int n, int k) {
        if (canWork(m, n, k) && !worked[m][n]) {
            num++;
            worked[m][n] = true;
            work(m + 1, n, k);
            work(m - 1, n, k);
            work(m, n + 1, k);
            work(m, n - 1, k);
        }

    }

    static boolean canWork(int i, int j, int k) {
        if (i < 0 || j < 0 || i >= M || j >= N)
            return false;
        int num = 0;
        while (i >= 10) {
            num += i % 10;
            i /= 10;
        }
        num += i;
        while (j >= 10) {
            num += j % 10;
            j /= 10;
        }
        num += j;
        return num <= k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m, n, k;
            m = scanner.nextInt();
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println("result::" + movingCount(m, n, k));

        }
    }
}
