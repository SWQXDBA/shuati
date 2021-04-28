package 每日一题;

import java.util.Scanner;

public class 查找输入整数二进制中1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            char[] bi = Integer.toBinaryString(n).toCharArray();
            int cnt = 0;
            for (char c : bi) {
                if (c == '1')
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
