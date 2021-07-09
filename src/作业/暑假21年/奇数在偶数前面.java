package 作业.暑假21年;

import java.util.Arrays;

public class 奇数在偶数前面 {
    static int[] function(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] % 2 == 0 && arr[j] % 2 != 0) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    static Integer[] function2(int[] arr) {
        Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i];
        }
        Arrays.sort(ints, (o1, o2) -> {
            if (((int) o1) % 2 == 0 && ((int) o2) % 2 != 0)
                return 1;
            return -1;
        });
        return ints;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 3, 6, 7};
        System.out.println(Arrays.toString(function(arr)));
        int[] arr2 = {1, 5, 4, 2, 3, 6, 7};
        System.out.println(Arrays.toString(function2(arr2)));
    }
}
