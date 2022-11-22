package 笔试题;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class 带权重的随机数 {

    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("题目示例的运行结果:");
        randomTest(new int[]{1, 2, 3, 4}, new int[]{2, 3, 1, 4}, 1000);
        randomTest(new int[]{1, 1, 3}, new int[]{2, 3, 5}, 1000);
        randomTest(new int[]{1, 2, -1}, new int[]{0, 1, 4}, 1000);
        System.out.println("自建测试用例:");
        randomTest(new int[]{1, 2, 3, 4}, new int[]{1, 1, 1, 1}, 1000);
        randomTest(new int[]{1, 2, 3, 4}, new int[]{0, 0, 0, 0}, 1000);
        randomTest(new int[]{1, 2, 3, 4}, new int[]{1, 1, 1, 999999}, 1000);
    }

    public static void randomTest(int[] nums, int[] weigh, int testCount) {
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < testCount; i++) {
            final int randomNum = randomPick(nums, weigh);
            counts.put(randomNum, counts.getOrDefault(randomNum, 0) + 1);
        }
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                System.out.println(num + " 次数:0");
            }
        }
        counts.forEach((key, value) -> {
            System.out.println(key + " 次数:" + value);
        });
        System.out.println();
    }

    public static int randomPick(int[] nums, int[] weight) {

        boolean isNotAllWeightZero = false;

        for (int i : weight) {
            isNotAllWeightZero = isNotAllWeightZero || (i != 0);
        }
        if (!isNotAllWeightZero) {
            Arrays.fill(weight, 1);
        }

        ValueWithWeight[] map = new ValueWithWeight[weight.length];
        double weightSum = 0;
        for (int i : weight) {
            weightSum += i;
        }
        for (int i = 0; i < weight.length; i++) {
            map[i] = new ValueWithWeight(nums[i], weight[i] / weightSum);
        }

        final double target = random.nextDouble();
        Arrays.sort(map);
        //根据权重进行排序后的nums数组
        final int[] sortedNums = Arrays.stream(map).mapToInt(it -> it.val).toArray();
        //权重数组 如[0.1 , 0.2 , 0.3 , 0.4]
        final double[] weights = Arrays.stream(map).mapToDouble(it -> it.weight).toArray();
        //使得weights[i]=weights[i]+weights[i-1]+...+weights[0],此时weights[i]相当于随机数小于i的可能性
        //如[0.1 , 0.3 , 0.6 , 1.0] 此时区间分为0-0.1 0.1-0.3 0.3-0.6 0.6-1.0 分别对应四个num
        for (int i = 1; i < weights.length; i++) {
            weights[i] += weights[i - 1];
        }
        //二分查找
        int targetIndex = Arrays.binarySearch(weights, target);
        //转化为插入点 即目标的下标值
        if (targetIndex < 0) {
            targetIndex = -targetIndex - 1;
        }
        return sortedNums[targetIndex];
    }

    static class ValueWithWeight implements Comparable<ValueWithWeight> {
        public int val;
        public double weight;

        public ValueWithWeight(int val, double weight) {
            this.val = val;
            this.weight = weight;
        }

        @Override
        public int compareTo(ValueWithWeight o) {
            return Double.compare(weight, o.weight);
        }
    }
}
