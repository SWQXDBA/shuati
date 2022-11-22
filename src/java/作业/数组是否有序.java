package 作业;

import java.util.Scanner;

public class 数组是否有序 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                System.out.println("不是有序的");
                return;
            }
        }
        System.out.println("有序的");
    }
}
