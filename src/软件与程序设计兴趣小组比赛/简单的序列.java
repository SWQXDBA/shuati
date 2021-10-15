package 软件与程序设计兴趣小组比赛;

import java.util.Scanner;
import java.util.Stack;

public class 简单的序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
                if (max < numbers[i]) {
                    max = numbers[i];
                }
            }

            boolean[] array = new boolean[max + 1];//用于欧拉筛 true为非素数
            init(array);


            for (int num : numbers) {
                if (num == 0) {
                    System.out.println(1);
                    System.out.println("0 = 0");
                    continue;
                }
                Stack<Integer> res = new Stack<>();
                getRes(res, num, array);
                System.out.println(res.size());
                while (!res.isEmpty()) {
                    System.out.print(res.pop());
                    if (!res.isEmpty()) {
                        System.out.print(" + ");
                    }
                }
                System.out.println(" = " + num);
            }
        }
    }

    public static void getRes(Stack<Integer> res, int num, boolean[] array) {
        int temp = num;
        while (temp >= 0 && array[temp]) {
            temp--;
        }
        //此时temp为最大的素数了
        res.push(temp);
        int need = num - temp;
        if (need == 0) {
            return;
        }

        getRes(res, need, array);
    }

    public static void init(boolean[] array) {
        int start = 2;
        while (start < array.length) {
            if (!array[start]) {
                int t = 2;
                while (start * t < array.length) {
                    array[start * t] = true;
                    t++;
                }
            }

            start++;

        }

    }

}
