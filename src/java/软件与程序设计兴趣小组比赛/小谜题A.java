package 软件与程序设计兴趣小组比赛;

import java.util.Scanner;

public class 小谜题A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long x = scanner.nextInt();
            System.out.println(func(x));
        }

    }

    public static long func(long x) {

        long step = 0;

        step = Math.round((-1 + Math.sqrt(1 + 4 * 2 * x)) / 2.0);
        //   System.out.println("setp:"+step);
        long loc = (step * step + step) / 2;
        if (loc < x) {
            step++;
        }
        loc = (step * step + step) / 2;
        //  System.out.println("loc:"+loc);
        if (loc - x == 1) {
            step++;
        }

        return step;
    }

}
