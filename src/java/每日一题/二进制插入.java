package 每日一题;

import java.util.Arrays;

public class 二进制插入 {
    public static class BinInsert {
        public static void main(String[] args) {
            System.out.println(new BinInsert().binInsert1(1024, 19, 2, 6));
            System.out.println(new BinInsert().binInsert2(1024, 19, 2, 6));
        }

        public int binInsert1(int n, int m, int j, int i) {
            String strn = Integer.toBinaryString(n);
            String strm = Integer.toBinaryString(m);

            char[] Char1 = Arrays.copyOfRange(strn.toCharArray(), 0, strn.length() - i - 1);
            char[] Char2 = Arrays.copyOf(strm.toCharArray(), strm.length());
            char[] Char3 = Arrays.copyOfRange(strn.toCharArray(), strn.length() - j - 1, strn.length() - 1);
            String stris = String.valueOf(Char1) + String.valueOf(Char2) + String.valueOf(Char3);
            return Integer.valueOf(stris, 2);
        }

        public int binInsert2(int n, int m, int j, int i) {

            return n + (m << j);
        }

    }
}
