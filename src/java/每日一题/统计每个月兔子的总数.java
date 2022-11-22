package 每日一题;

import java.util.Scanner;

public class 统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int arr[] = new int[3];
            int n = scanner.nextInt();
            arr[0] = 1;
            for (int i = 1; i < n; i++) {
                arr[2] += arr[1];
                arr[1] = arr[0];
                arr[0] = arr[2];
            }
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
    }
}
