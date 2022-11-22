package 每日一题;

import java.util.Scanner;

public class 求最大连续bit数 {
    //其实测试数字是int
    //方法一 位运算
    //由于java的>>是有符号位移，所以如果是负数 会在左侧补1而不是0。所以用无符号右移>>>
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
//         while (in.hasNextByte()) {
//             byte num = in.nextByte();
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int max = 0;
            int count = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
                num >>>= 1;
            }
            System.out.println(max);
        }
    }

    //方法2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//         while (in.hasNextByte()) {
//             byte num = in.nextByte();

        int num = in.nextInt();
        //把二进制转化成字符串
        String str = Integer.toBinaryString(num);
        //0+这里+表示多个0
        String[] strs = str.split("0+");
        int count = 0;
        for (String s : strs) {
            count = Math.max(count, s.length());
        }

        System.out.println(count);

    }

}
