package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 2, 2, 2};
        int[] arr2 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new 数组中出现次数超过一半的数字().MoreThanHalfNum_Solution(arr2));
        System.out.println(new 数组中出现次数超过一半的数字().MoreThanHalfNum_Solution2(arr2));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        //数字 次数
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        int integer = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > max) {
                max = entry.getValue();
                integer = entry.getKey();
            }
        }
        return integer;

    }

    //方法2 o(1)空间 o(n)时间复杂度
    public int MoreThanHalfNum_Solution2(int[] array) {
        int num = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != num) {
                cnt--;
            } else {
                cnt++;
            }
            if (cnt == 0) {
                num = array[i];
                cnt = 1;
            }
        }
        return num;
    }
}
