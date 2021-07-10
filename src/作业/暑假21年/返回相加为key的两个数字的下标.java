package 作业.暑假21年;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 返回相加为key的两个数字的下标 {
    static int[] func(int[] arr, int target) {
        int ret[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i : arr) {
            if (map.get(target - i) != null) {
                ret[0] = map.get(i);
                ret[1] = map.get(target - i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 7, 8};
        System.out.println(Arrays.toString(func(arr, 8)));
    }
}
