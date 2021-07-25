package 作业.暑假21年;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class k个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right, left;

        right = Arrays.binarySearch(arr, x);
        for (right = 0; right < arr.length; right++) {
            if (arr[right] > x) {
                break;
            }
        }
        left = right - 1;
        List<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            if (right >= arr.length) {
                list.add(arr[left]);
                left--;
                continue;
            }
            if (left < 0) {
                list.add(arr[right]);
                right++;
                continue;
            }
            if (Math.abs(arr[right] - x) >= Math.abs(arr[left] - x)) {
                list.add(arr[left]);
                left--;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        list.sort(Integer::compare);
        return list;
    }
}
