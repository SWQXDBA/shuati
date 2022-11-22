package 作业;

import java.util.Scanner;

public class 二分查找 {
    public static int binarySearch(int[] arr, int num) {
        int half = arr.length / 2;
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            if (arr[half] == num) {
                return half;
            }
            if (arr[half] < num) {
                left = half + 1;
            }
            if (arr[half] > num) {
                right = half - 1;
            }
            half = right + left;
            half /= 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("输入要查找的数");
        System.out.println("在第" + binarySearch(arr, scanner.nextInt()) + "位");

    }
}
