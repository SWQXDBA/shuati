package 每日一题;

import java.util.Scanner;

//题目描述
//        牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。牛牛有一 个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数 组分为几段排序子序列.
//        如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出 2
//        输入描述： 输入的第一行为一个正整数n(1 ≤ n ≤ 10^5)
//        第二行包括n个整数A_i(1 ≤ A_i ≤ 10^9),表示数组A的每个数字。
//        输出描述： 输出一个整数表示牛牛可以将A最少划分为多少段排序子序列
//        ————————————————
//        版权声明：本文为CSDN博主「ly_1115」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/ly_6699/article/details/90531449
public class 排序子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int cnt = 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2]) {
                cnt++;
            }
            if (nums[i] > nums[i + 1] && nums[i + 1] > nums[i + 2]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
