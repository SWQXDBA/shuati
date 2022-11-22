package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class 组队竞赛 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] array = new long[3 * n];
            for (int i = 0; i < 3 * n; i++) {
                array[i] = scanner.nextLong();
            }
            Arrays.sort(array);
            long sum = 0;
            int i = 3 * n - 2;
            for (int j = 0; j < n; j++) {
                sum += array[i];
                i -= 2;
            }
            System.out.println(sum);
        }
    }
}
