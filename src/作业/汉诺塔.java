package 作业;

import java.util.Scanner;

public class 汉诺塔 {

    //n=第n小的盘子
    static void hannor(int n, String from, String to, String buffer) {
        if (n == 1) {
            System.out.println(n + "从" + from + "移动到了" + to + "号盘子");
            return;
        }
        hannor(n - 1, from, buffer, to);
        System.out.println(n + "从" + from + "移动到了" + to + "号盘子");
        hannor(n - 1, buffer, to, from);

    }

    public static void main(String[] args) {
        Long time1 = System.currentTimeMillis();
        hannor(new Scanner(System.in).nextInt(), "A", "C", "B");
        Long time2 = System.currentTimeMillis();
        System.out.println("用了" + (time2 - time1) / 1000 + "秒");
    }
}
