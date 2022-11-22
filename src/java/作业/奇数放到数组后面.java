package 作业;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 奇数放到数组后面 {
    public static void func(int[] arr) {
        Integer[] integers = new Integer[arr.length];
        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            integers[i] = arr[i];
            if (arr[i] % 2 == 0) {
                ou.add(arr[i]);
            } else {
                ji.add(arr[i]);
            }
        }
        List<Integer> all = new ArrayList<>();
        all.addAll(ou);
        all.addAll(ji);
        integers = all.toArray(integers);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integers[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }
        func(arr);
        System.out.println(Arrays.toString(arr));
    }
}
