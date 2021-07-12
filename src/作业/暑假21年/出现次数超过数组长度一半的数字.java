package 作业.暑假21年;

import java.util.HashMap;
import java.util.Map;

public class 出现次数超过数组长度一半的数字 {
    static int fun(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer num = map.get(i);
            if (num == null) {
                map.put(i, 1);
            } else {
                map.put(i, num + 1);
            }
        }

        int half = arr.length / 2;
        for (int i : arr) {
            Integer num = map.get(i);
            if (num > half) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(fun(arr));
    }
}
