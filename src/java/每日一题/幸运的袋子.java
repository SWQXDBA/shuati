package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class 幸运的袋子 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(dfs(arr, 0, 0, 1));
            /*     System.out.println(getLuckyPacket(arr, n, 0, 0, 1));*/


        }
    }

    public static int dfs(int[] arr, int cur, int sum, int multi) {
        int cnt = 0;
        for (int i = cur; i < arr.length; i++) {
            sum += arr[i];
            multi *= arr[i];
            if (sum > multi) {
                cnt += (1 + dfs(arr, i + 1, sum, multi));
            } else if (arr[i] == 1) {//其实只针对数组开头的1 后面连续的1不会走这个if而是走上面的if
                cnt += dfs(arr, i + 1, sum, multi);
            } else {
                break;
            }


            sum -= arr[i];
            multi /= arr[i];
            while (i < arr.length - 1 && arr[i + 1] == arr[i]) {
                i++;
            }
        }

        return cnt;
    }
/*
    static int getLuckyPacket(int[] x, int n, int pos, int sum, int multi) {
        int count = 0;
        //循环，搜索以位置i开始所有可能的组合
        for (int i = pos; i < n; i++) {
            sum += x[i];
            multi *= x[i];
            if (sum > multi) {
                //找到符合要求的组合，加1，继续累加后续的值，看是否有符合要求的集合
                count += 1 + getLuckyPacket(x, n, i + 1, sum, multi);
            } else if (x[i] == 1) {
                //如何不符合要求，且当前元素值为1，则继续向后搜索
                count += getLuckyPacket(x, n, i + 1, sum, multi);
            } else {
                //如何sum大于multi,则后面就没有符合要求的组合了
                break;
            }
            //要搜索下一个位置之前，首先恢复sum和multi
            sum -= x[i];
            multi /= x[i];
            //数字相同的球，没有什么区别，都只能算一个组合，所以直接跳过
            while (i < n - 1 && x[i] == x[i + 1]) {
                i++;
            }
        }
        return count;
    }*/

}
