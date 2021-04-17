package 作业;

import java.util.Arrays;
import java.util.Scanner;

public class 数组平均值 {
    static double Average(int[] arr) {
        double sum = 0;
        for (int i : arr
        ) {
            sum += i;
        }
        return sum / arr.length;
    }

    static int Sum(int[] arr) {
        int sum = 0;
        for (int i : arr
        ) {
            sum += i;
        }
        return sum;
    }

    static void two(int[] arr) {

        for (int i = 0; i < arr.length; i++
        ) {
            arr[i] *= 2;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }
        two(arr);
        System.out.println(Arrays.toString(arr));

    }
}
