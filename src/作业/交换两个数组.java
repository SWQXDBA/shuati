package 作业;

import java.util.Arrays;
import java.util.Scanner;

public class 交换两个数组 {
    public static void changeArray(int[] arr1, int[] arr2) {
        int min = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < min; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = scanner.nextInt();
        }
        int[] arr2 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr2[i] = scanner.nextInt();
        }
        changeArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
